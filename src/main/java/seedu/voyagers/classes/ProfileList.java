package seedu.voyagers.classes;

import seedu.voyagers.VoyagerException;

import java.util.ArrayList;

public class ProfileList {
    /**
     * Represents a list of all profiles across trips. Static class since one ProfileList is used across all trips.
     */

    private static ArrayList<Profile> profileList = new ArrayList<>();

    public ProfileList(ArrayList<Profile> profiles){
    }

    /**
     * Adds a profile to the list
     * @param profile the profile to add
     */
    public static void add(Profile profile){
        if (isProfileNameRepeated(profile.getName())){
            throw new IllegalArgumentException("Profile name already exists");
        }
        profileList.add(profile);
    }

    /**
     * Removes a Profile from the list
     * @param index the index of the profile to remove. Index starts from 1
     * @return the profile that was removed
     * @throws VoyagerException if the index is invalid
     */
    public static Profile remove(String index) throws VoyagerException{
        Profile profile = profileList.get(checkIndex(index) - 1);
        profileList.remove(checkIndex(index) - 1);
        return profile;
    }

    /**
     * Removes a profile from the list
     * @param index the index of the profile to remove. Index starts from 0
     * @return the profile that was removed
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public static Profile remove(int index) throws IndexOutOfBoundsException{
        Profile profile = profileList.get(index);
        profileList.remove(index);
        return profile;
    }

    /**
     * Returns the profile at the specified index
     * @param index the index of the profile to return. Index starts from 0
     * @return the profile at the specified index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public static Profile get(int index) throws IndexOutOfBoundsException{
        return profileList.get(index);
    }

    /**
     * Returns the profile at the specified index
     * @param index the index of the profile to return. Index starts from 1
     * @return the profile at the specified index
     * @throws VoyagerException if the index is invalid
     */
    public static Profile get(String index) throws VoyagerException{
        return profileList.get(checkIndex(index) - 1);
    }

    /**
     * Tries to parse the index to an integer and checks if it is within the range of the list.
     * Index starts from 1.
     * @param index the index to check
     * @return the index as an integer
     */
    private static int checkIndex(String index) throws VoyagerException{
        int i;
        try{
            i = Integer.parseInt(index);
        } catch (NumberFormatException e){
            throw new VoyagerException("Please enter a valid number");
        }

        if (i > profileList.size() || i < 1){
            throw new VoyagerException("Sorry. There are only " + profileList.size() + " profiles in the list");
        }

        return i;
    }

    /**
    * Finds the index of the profile with the specified name
    * @param name the name of the profile to find
    * @return the index of the profile with the specified name. Returns -1 if no such profile is found
    */
    public static int findProfile(String name){
        for (int i = 0; i < profileList.size(); i++){
            if (profileList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }



    public static Profile getProfile(String name) throws IllegalArgumentException{
        int index = findProfile(name);
        if (index == -1){
            throw new IllegalArgumentException("No such profile found");
        }
        return profileList.get(index);
    }

    public static boolean isProfileNameRepeated(String name){
        return findProfile(name) != -1;
    }



    public static ArrayList<Profile> getProfiles(){
        return profileList;
    }

    /**
     * Returns the number of profiles in the list
     * @return the number of profiles in the list
     */
    public static int size(){
        return profileList.size();
    }
}

