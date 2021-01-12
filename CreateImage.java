package com.example.Character;

import android.app.Application;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class createImage {

    private Resources res;
    private boolean hasPreSetValues;
    private savedCharacterStructure charStruct;
    private String combinedString;
    //region choosenProperties
    private String gender;
    private int choosenTint;
    private int choosenHairColor;
    private int choosenHair;
    private int choosenFaceComplete;
    private int choosenEyebrows;
    private int choosenEyes;
    private int choosenMouth;
    private int choosenNose;
    //endregion
    //region characterArray
    private int[] tintArray;
    private ArrayList<Bitmap> tintStuff;
    private int[] faceArray;
    private ArrayList<Bitmap> eyebrowsArray;
    private ArrayList<Bitmap> eyesArray;
    private ArrayList<Bitmap> mouthArray;
    private ArrayList<Bitmap> noseArray;
    private int[] hairColorArray;
    private ArrayList<Bitmap> hairArray;
    //endregion
    //region getSetProperties
    public void setGender(String name){gender = name;}
    public String getGender(){return gender;}
    public void setChoosenTint(int name){choosenTint = name;}
    public int getChoosenTint(){return choosenTint;}
    public void setChoosenHairColor(int name){choosenHairColor = name;}
    public int getChoosenHairColor(){return choosenHairColor;}
    public void setChoosenHair(int name){choosenHair = name;}
    public int getChoosenHair(){return choosenHair;}
    public void setChoosenFaceComplete(int name){choosenFaceComplete = name;}
    public int getChoosenFaceComplete(){return choosenFaceComplete;}
    public void setChoosenEyebrows(int name){choosenEyebrows = name;}
    public int getChoosenEyebrows(){return choosenEyebrows;}
    public void setChoosenEyes(int name){choosenEyes = name;}
    public int getChoosenEyes(){return choosenEyes;}
    public void setChoosenMouth(int name){choosenMouth = name;};
    public int getChoosenMouth(){return choosenMouth;};
    public void setChoosenNose(int name){choosenNose = name;}
    public int getChoosenNose(){return choosenNose;}

    //endregion

    public createCharacterImage(Resources resource, boolean hasValues, savedCharacterStructure characterStructure, String combined)
    {
        res = resource;
        hasPreSetValues = hasValues;
        charStruct = characterStructure;
        combinedString = combined;

        preloadImageArrays();
        setChoosenDefaults();
        setupArrays();
    }
    //region preloadImages
    public void preloadImageArrays()
    {
        tintArray = new int[] {1,2,3,4,5,6,7,8};
        hairColorArray = new int[] {1,2,3,4,5,6,7,8};
        faceArray = new int[] {1,2,3,4};

        tintStuff = new ArrayList<Bitmap> ();
        eyebrowsArray = new ArrayList<Bitmap> ();
        eyesArray = new ArrayList<Bitmap> ();
        mouthArray = new ArrayList<Bitmap> ();
        noseArray = new ArrayList<Bitmap> ();
        hairArray = new ArrayList<Bitmap> ();
    }
    public void setChoosenDefaults()
    {
        if(hasPreSetValues)
        {
            gender = charStruct.gender;
            choosenTint = charStruct.tint;
            choosenHairColor = charStruct.haircolor;
            choosenHair = charStruct.hair;
            choosenFaceComplete = charStruct.face;
            choosenEyebrows = charStruct.eyebrows;
            choosenEyes = charStruct.eyes;
            choosenMouth = charStruct.mouth;
            choosenNose = charStruct.nose;

        }
        else
        {
            gender = charStruct.gender;
            choosenTint = 8;
            choosenHairColor = 1;
            choosenHair = 3;
            choosenFaceComplete = 1;
            choosenEyebrows = 1;
            choosenEyes = 1;
            choosenMouth = 1;
            choosenNose = 1;
        }

    }
    //endregion
    //region characterInfo
    public void setStructureFromCombined()
    {
        String[] combinedArray = combinedString.split(",");

        charStruct.tint =  Integer.parseInt(combinedArray[0]);
        charStruct.nose =  Integer.parseInt(combinedArray[1]);
        charStruct.mouth =  Integer.parseInt(combinedArray[2]);
        charStruct.eyes =  Integer.parseInt(combinedArray[3]);
        charStruct.eyebrows =  Integer.parseInt(combinedArray[4]);
        charStruct.face =  Integer.parseInt(combinedArray[5]);
        charStruct.hair =  Integer.parseInt(combinedArray[6]);
        charStruct.hair =  Integer.parseInt(combinedArray[7]);
        charStruct.haircolor =  Integer.parseInt(combinedArray[8]);
    }
    public void setCombinedFromStructure()
    {
        combinedString = String.format("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s,%8$s,%9$s,1,1,1,1,1,1,1,1,",charStruct.tint,charStruct.nose,charStruct.mouth,charStruct.eyes,charStruct.eyebrows,charStruct.face,charStruct.hair,charStruct.hair,charStruct.haircolor);
    }
    public String getCombinedString()
    {
        return combinedString;
    }
    public void setSavedCharacterStructure()
    {
        charStruct.gender = gender;
        charStruct.tint = choosenTint;
        charStruct.haircolor = choosenHairColor ;
        charStruct.hair =  choosenHair ;
        charStruct.face = choosenFaceComplete ;
        charStruct.eyebrows = choosenEyebrows ;
        charStruct.eyes = choosenEyes ;
        charStruct.mouth = choosenMouth ;
        charStruct.nose = choosenNose ;


    }
    public savedCharacterStructure getCharacterInfo()
    {
        return charStruct;
    }
    //endregion
    //region setupArrays
    // these are the arrays that I use to create the different choices of images from and I use res to import them into the array. I make sure the array is clear before continuing to stop duplication.
    {
        setupTintStuffArray();
        setupNoseArray();
        setupEyebrowsArray();
        setupHairArray();
        setupEyesArray();
        setupMouthArray();
    }
    public void setupTintStuffArray()
    {
        tintStuff.clear();

        tintStuff.add(BitmapFactory.decodeResource(res, R.drawable.tint1_head));
        tintStuff.add(BitmapFactory.decodeResource(res, R.drawable.tint2_head));
        tintStuff.add(BitmapFactory.decodeResource(res, R.drawable.tint3_head));
        tintStuff.add(BitmapFactory.decodeResource(res, R.drawable.tint4_head));
        tintStuff.add(BitmapFactory.decodeResource(res, R.drawable.tint5_head));
        tintStuff.add(BitmapFactory.decodeResource(res, R.drawable.tint6_head));
        tintStuff.add(BitmapFactory.decodeResource(res, R.drawable.tint7_head));
        tintStuff.add(BitmapFactory.decodeResource(res, R.drawable.tint8_head));
    }
    public void setupNoseArray()
    {
        noseArray.clear();

        switch(choosenTint)
        {
            case 1:
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint1nose1));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint1nose2));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint1nose3));
                break;
            case 2:
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint2nose1));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint2nose2));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint2nose3));
                break;
            case 3:
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint3nose1));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint3nose2));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint3nose3));
                break;
            case 4:
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint4nose1));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint4nose2));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint4nose3));
                break;
            case 5:
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint5nose1));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint5nose2));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint5nose3));
                break;
            case 6:
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint6nose1));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint6nose2));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint6nose3));
                break;
            case 7:
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint7nose1));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint7nose2));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint7nose3));
                break;
            case 8:
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint8nose1));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint8nose2));
                noseArray.add(BitmapFactory.decodeResource(res, R.drawable.tint8nose3));
                break;
        }
    }
    public void setupEyebrowsArray() {
        eyebrowsArray.clear();

        switch (choosenHairColor) {
            case 1:
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.blackbrow1));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.blackbrow2));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.blackbrow3));
                break;
            case 2:
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.blondebrow1));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.blondebrow2));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.blondebrow3));
                break;
            case 3:
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1brow1));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1brow2));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1brow3));
                break;
            case 4:
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2brow1));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2brow2));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2brow3));
                break;
            case 5:
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.greybrow1));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.greybrow2));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.greybrow3));
                break;
            case 6:
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.redbrow1));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.redbrow2));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.redbrow3));
                break;
            case 7:
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.tanbrow1));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.tanbrow2));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.tanbrow3));
                break;
            case 8:
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.whitebrow1));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.whitebrow2));
                eyebrowsArray.add(BitmapFactory.decodeResource(res, R.drawable.whitebrow3));
                break;
        }
    }
    public void setupHairArray()
    {
        hairArray.clear();

        switch (choosenHairColor) {
            case 1:
                if(gender == "boy")
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackman6));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackman7));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackman8));
                }
                else
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackwoman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackwoman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackwoman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackwoman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackwoman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blackwoman6));
                }
                break;
            case 2:
                if(gender == "boy")
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondeman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondeman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondeman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondeman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondeman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondeman6));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondeman7));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondeman8));
                }
                else
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondewoman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondewoman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondewoman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondewoman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondewoman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.blondewoman6));
                }
                break;
            case 3:
                if(gender == "boy")
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1man1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1man2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1man3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1man4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1man5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1man6));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1man7));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1man8));
                }
                else
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1woman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1woman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1woman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1woman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1woman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown1woman6));
                }
                break;
            case 4:
                if(gender == "boy")
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2man1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2man2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2man3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2man4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2man5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2man6));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2man7));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2man8));
                }
                else
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2woman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2woman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2woman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2woman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2woman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.brown2woman6));
                }
                break;
            case 5:
                if(gender == "boy")
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greyman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greyman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greyman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greyman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greyman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greyman6));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greyman7));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greyman8));
                }
                else
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greywoman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greywoman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greywoman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greywoman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greywoman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.greywoman6));
                }
                break;
            case 6:
                if(gender == "boy")
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redman6));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redman7));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redman8));
                }
                else
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redwoman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redwoman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redwoman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redwoman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redwoman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.redwoman6));
                }
                break;
            case 7:
                if(gender == "boy")
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanman6));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanman7));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanman8));
                }
                else
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanwoman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanwoman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanwoman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanwoman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanwoman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.tanwoman6));
                }
                break;
            case 8:
                if(gender == "boy")
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whiteman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whiteman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whiteman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whiteman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whiteman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whiteman6));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whiteman7));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whiteman8));
                }
                else
                {
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whitewoman1));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whitewoman2));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whitewoman3));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whitewoman4));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whitewoman5));
                    hairArray.add(BitmapFactory.decodeResource(res, R.drawable.whitewoman6));
                }
                break;
        }
    }

    public void setupEyesArray()
    {
        eyesArray.clear();

        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyeblack_small));
        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyeblack_large));
        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyeblue_small));
        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyeblue_large));
        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyebrown_small));
        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyebrown_large));
        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyegreen_small));
        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyegreen_large));
        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyepine_small));
        eyesArray.add(BitmapFactory.decodeResource(res, R.drawable.eyepine_large));

    }
    public void setupMouthArray()
    {
        mouthArray.clear();

        mouthArray.add(BitmapFactory.decodeResource(res, R.drawable.mouth_glad));
        mouthArray.add(BitmapFactory.decodeResource(res, R.drawable.mouth_happy));
        mouthArray.add(BitmapFactory.decodeResource(res, R.drawable.mouth_oh));
        mouthArray.add(BitmapFactory.decodeResource(res, R.drawable.mouth_sad));
        mouthArray.add(BitmapFactory.decodeResource(res, R.drawable.mouth_straight));
        mouthArray.add(BitmapFactory.decodeResource(res, R.drawable.mouth_teethlower));
        mouthArray.add(BitmapFactory.decodeResource(res, R.drawable.mouth_teethupper));
    }
    //endregion

    //region incrementsOption
    public Bitmap incrementAndReturnImage(boolean forward,int currentEdit)
    {
        switch(currentEdit)
        {
            case 0:
                choosenTint = incrementChoosenFromArray(forward,choosenTint,tintArray.length);
                setupNoseArray();
                break;
            case 1:
                choosenFaceComplete = incrementChoosenFromArray(forward,choosenFaceComplete,faceArray.length);
                break;
            case 2:
                choosenHairColor = incrementChoosenFromArray(forward,choosenHairColor,hairColorArray.length);
                setupEyebrowsArray();
                setupHairArray();
                break;
            case 3:
                choosenHair = incrementChoosenFromArray(forward,choosenHair,hairArray.size());
                break;
            case 4:
                choosenEyebrows = incrementChoosenFromArray(forward,choosenEyebrows,eyebrowsArray.size());
                break;
            case 5:
                choosenEyes = incrementChoosenFromArray(forward,choosenEyes,eyesArray.size());
                break;
            case 6:
                choosenMouth = incrementChoosenFromArray(forward,choosenMouth,mouthArray.size());
                break;
            case 7:
                choosenNose = incrementChoosenFromArray(forward,choosenNose,noseArray.size());
                break;
        }
        setSavedCharacterStructure();

        return returnFaceImage();

    }
    public int incrementChoosenFromArray(boolean forward, int choosenNum, int arrayCount)
    {
        int newNum;

        if(forward && arrayCount == choosenNum)
        {
            newNum = 1;
        }
        else if(!forward && choosenNum == 1)
        {
            newNum = arrayCount;
        }
        else
        {
            newNum = forward ? (choosenNum+1) : (choosenNum-1);
        }

        return newNum;
    }
    //endregion
    //region createImages
    public Bitmap returnFaceImage()
    {
        // create a bitmap from the choosen image. I then create a matrix in the right position. i then create a bitmap for import
        // i then draw a bitmap in the right angle 

        Bitmap head = tintStuff.get(choosenTint-1);
        Bitmap leftEye = eyesArray.get(choosenEyes-1);
        Bitmap rightEye = eyesArray.get(choosenEyes-1);
        Bitmap nose =  noseArray.get(choosenNose-1);
        Bitmap mouth = mouthArray.get(choosenMouth-1);
        Bitmap leftEyebrow = eyebrowsArray.get(choosenEyebrows-1);
        Bitmap rightEyebrow = eyebrowsArray.get(choosenEyebrows-1);
        Bitmap hair = hairArray.get(choosenHair-1);
        //Bitmap hair = BitmapFactory.decodeResource(res, R.drawable.tanwoman3);
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        rightEyebrow = Bitmap.createBitmap(rightEyebrow,0,0,rightEyebrow.getWidth(),rightEyebrow.getHeight(),matrix,true);
        Bitmap neck = BitmapFactory.decodeResource(res, R.drawable.tint1_neck);
        //neck = Bitmap.createBitmap(neck,0,0,neck.getWidth()/4,neck.getHeight()/2);


        Bitmap result = Bitmap.createBitmap(300,300,head.getConfig());
        Canvas canvas = new Canvas(result);

        switch(choosenFaceComplete)
        {
            case 1:
                //facecomplete1
                canvas.drawBitmap(head,0,0,null);
                canvas.drawBitmap(leftEye,63,79,null);
                canvas.drawBitmap(rightEye,165,79,null);
                canvas.drawBitmap(nose,100,116,null);
                canvas.drawBitmap(mouth,116,180,null);
                canvas.drawBitmap(leftEyebrow,52,9,null);
                canvas.drawBitmap(rightEyebrow,154,24,null);
            break;
            case 2:
                //facecomplete2
                canvas.drawBitmap(head,0,0,null);
                canvas.drawBitmap(leftEye,85,77,null);
                canvas.drawBitmap(rightEye,163,79,null);
                canvas.drawBitmap(nose,105,116,null);
                canvas.drawBitmap(mouth,117,181,null);
                canvas.drawBitmap(leftEyebrow,53,28,null);
                canvas.drawBitmap(rightEyebrow,152,5,null);
            break;
            case 3:
                //facecomplete3
                canvas.drawBitmap(head, 0, 0, null);
                canvas.drawBitmap(leftEye, 68, 77, null);
                canvas.drawBitmap(rightEye, 173, 85, null);
                canvas.drawBitmap(nose, 108, 110, null);
                canvas.drawBitmap(mouth, 102, 185, null);
                canvas.drawBitmap(leftEyebrow, 50, 22, null);
                canvas.drawBitmap(rightEyebrow, 159, 27, null);
                break;
            case 4:
                //facecomplete4
                canvas.drawBitmap(head,0,0,null);
                canvas.drawBitmap(leftEye,68,57,null);
                canvas.drawBitmap(rightEye,165,64,null);
                canvas.drawBitmap(nose,100,83,null);
                canvas.drawBitmap(mouth,116,177,null);
                canvas.drawBitmap(leftEyebrow,53,14,null);
                canvas.drawBitmap(rightEyebrow,160,28,null);
                break;
        }

        Bitmap result1 = Bitmap.createBitmap(300,300,head.getConfig());

        Canvas canvas1 = new Canvas(result1);
        // drawn based on gender differences
        if(gender == "boy")
        {
            canvas1.drawBitmap(result,0,52,null);
            canvas1.drawBitmap(hair,13,5,null);
        }
        else
        {
            canvas1.drawBitmap(hair,15,0,null);
            canvas1.drawBitmap(result,0,52,null);
        }
        // I return the created image
        return result1;

    }


    public Bitmap testreturn()
    {


        Bitmap first = BitmapFactory.decodeResource(res, R.drawable.tint1_head);
        //Bitmap second = BitmapFactory.decodeResource(res, R.drawable.face1);
        Bitmap second = BitmapFactory.decodeResource(res, R.drawable.eyeblack_large);
        Bitmap third = BitmapFactory.decodeResource(res, R.drawable.eyeblack_large);
        Bitmap nose =  BitmapFactory.decodeResource(res, R.drawable.tint1nose1);
        Bitmap mouth = BitmapFactory.decodeResource(res, R.drawable.mouth_glad);
        Bitmap eyebrow = BitmapFactory.decodeResource(res, R.drawable.blackbrow1);
        Bitmap eyebrow1 = BitmapFactory.decodeResource(res, R.drawable.blackbrow1);
        Bitmap hair = BitmapFactory.decodeResource(res, R.drawable.tanman1);
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        eyebrow1 = Bitmap.createBitmap(eyebrow1,0,0,eyebrow1.getWidth(),eyebrow1.getHeight(),matrix,true);
        Bitmap neck = BitmapFactory.decodeResource(res, R.drawable.tint1_neck);



        Bitmap result = Bitmap.createBitmap(300,300,first.getConfig());


        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(first,0,0,null);
        canvas.drawBitmap(second,68,77,null);
        canvas.drawBitmap(third,173,85,null);
        canvas.drawBitmap(nose,108,110,null);
        canvas.drawBitmap(mouth,102,185,null);
        canvas.drawBitmap(eyebrow,50,22,null);
        canvas.drawBitmap(eyebrow1,159,27,null);


        Bitmap result1 = Bitmap.createBitmap(300,300,first.getConfig());
        Canvas canvas1 = new Canvas(result1);

        canvas1.drawBitmap(result,0,52,null);
        canvas1.drawBitmap(hair,15,0,null);

        return result1;

    }
    //endregion
}
