package com.example.farahshadid.callyourmother;
import android.util.Log;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class User {
    public String username;
    public ArrayList<String> topContacts;
    public int commitmentScore;
    private DatabaseReference mDatabase;
    private FirebaseDatabase database;
    private static final String TAG = "Firebase Activity: ";

    public User(String username,ArrayList<String> topContacts, int commitmentScore){
        this.username = username;
        this.topContacts = topContacts;
        this.commitmentScore = commitmentScore;
        mDatabase = FirebaseDatabase.getInstance().getReference().getRoot();
        database = FirebaseDatabase.getInstance();

    }

    /**
     * add a new user under users in the database with a commitment Score of 0
     * @param userId
     * @param topContactsList
     */
    public void writeNewUser(String userId, ArrayList<String> topContactsList) {
        User user = new User(userId,topContactsList,0);
        mDatabase.child("Users").child(userId).setValue(user);
        Log.v(TAG, "inserted " + userId + " to the database");
    }

    /**
     * remove a user from the data base
     * @param user
     */

    public void removeUser(User user){
        mDatabase.child("Users").child(user.username).removeValue();
        Log.v(TAG, "removed " + user.username + " from the database");
    }

    /**
     * update the commitmentScore of a user
     * @param user
     * @param newCommitmentScore
     */
    public void updateCommitmentScore(User user,int newCommitmentScore){
        mDatabase.child("Users").child(user.username).child("commitmentScore").setValue(newCommitmentScore);
        Log.v(TAG, "Updated " + user.username + "'s from the database");
    }

}
