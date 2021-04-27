package com.example.blooddonation;

public class Donationjava {

    String PostId;
    String DonationId;
    String Howdidyouknow;

    public Donationjava(String PostId, String DonationId, String Howdidyouknow) {
        PostId = PostId;
        DonationId = DonationId;
        Howdidyouknow = Howdidyouknow;
    }

    String getPostId ()
    {
        return PostId;
    }

    String getDonationId()
    {
        return DonationId;
    }

    String getHowdidyouknow()
    {
        return Howdidyouknow;
    }

    public void setPostId(String postId) {
        PostId = postId;
    }

    public void setDonationId(String donationId) {
        DonationId = donationId;
    }

    public void setHowdidyouknow(String howdidyouknow) {
        Howdidyouknow = howdidyouknow;
    }
}
