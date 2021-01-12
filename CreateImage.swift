//
//  CreateImage.swift
//  Copyright © 2020 Cameron Daniels.
//

import Foundation
import UIKit
import SpriteKit
import GameplayKit
import AVFoundation

class CreateImageForCharacter
{
    //list of variables for chosing the specific image wanted
    var defaults : UserDefaults?
    var hasPreSetValues : Bool?
    var gender : String?
    var chosenTint : Int?
    var choosenHairColor : Int?
    var choosenHair : Int?
    var choosenFaceComplete : Int?
    var choosenEyebrows : Int?
    var choosenEyes : Int?
    var choosenMouth : Int?
    var choosenNose : Int?
    var choosenShirtColor : Int?
    var choosenShirt : Int?
    var choosenShirtSide : Int?
    var choosenPantsColor : Int?
    var choosenPantsBottom : Int?
    var choosenPants : Int?
    var choosenShoesColor : Int?
    var choosenShoes : Int?
    
    //image arrays for keeping track of all image names
    var tintArray :[Int] = []
    var tintStuff :[UIImage?] = []
    var faceCompleteArray :[UIImage?] = []
    var eyebrowsArray :[UIImage?] = []
    var eyesArray :[UIImage?] = []
    var mouthArray :[UIImage?] = []
    var noseArray :[UIImage?] = []
    var hairColorArray :[Int] = []
    var hairArray :[UIImage?] = []
    var pantsArray :[UIImage?] = []
    var pantsBottomArray :[UIImage?] = []
    var pantsColorArray :[Int] = []
    var shirtsArray :[UIImage?] = []
    var shirtsSidesArray :[UIImage?] = []
    var shirtsColorArray :[Int] = []
    var shoesArray :[UIImage?] = []
    var shoesColorArray :[Int] = []
    
    //MARK: -  Init functions
    //needs to know if have choosen values before and gender must be know
    init(hasPresetValue : Bool, genderValue : String)
    {
        self.hasPreSetValues = hasPresetValue
        self.gender = genderValue
    }
    //MARK: -  Select Image Arrays
    func ShowFaceImage() -> UIImage
    {
        //get images from the arrays from either default or choosen values
        let faceImage = self.tintStuff[2]
        let eyesImage = self.eyesArray[self.choosenEyes!-1]
        let eyebrowsImage = self.eyebrowsArray[self.choosenEyebrows!-1]
        let noseImage = self.noseArray[self.choosenNose!-1]
        let mouthImage = self.mouthArray[self.choosenMouth!-1]
        let hairImage = self.hairArray[self.choosenHair!-1]
        let neckImage = self.tintStuff[4]
        
        //create the size and position of the rect that is going to be drawn
        let faceSize = CGRect(x: 0, y: 0, width: 170, height: 140)
        let neckSize = CGRect(x: 71, y: 139, width: 44, height: 16)
        let hairSize = CGRect(x: 0, y: 0, width: 173, height: 128)
        var leftEyeSize = CGRect.init()
        var rightEyeSize = CGRect.init()
        var leftEyebrowSize = CGRect.init()
        var rightEyebrowSize = CGRect.init()
        var mouthSize = CGRect.init()
        var noseSize = CGRect.init()
        

        //creates face from all face images from the parameters given and creates cgect
        chooseFaceSizes(eyesSize1: &leftEyeSize, eyesSize2: &rightEyeSize, eyebrowsSize1: &leftEyebrowSize, eyebrowsSize2: &rightEyebrowSize, noseeSize: &noseSize, mouthSize: &mouthSize)
        
        // then I create a cgsize variable then I draw in all the images to the size
        
        let size = CGSize(width: 173, height: 173)
        UIGraphicsBeginImageContext(size)
        
        faceImage?.draw(in: faceSize)
        eyesImage?.draw(in: leftEyeSize)
        eyesImage?.draw(in: rightEyeSize)
        eyebrowsImage?.draw(in: leftEyebrowSize)
        eyebrowsImage?.draw(in: rightEyebrowSize)
        noseImage?.draw(in: noseSize)
        mouthImage?.draw(in: mouthSize)
        noseImage?.draw(in: noseSize)
        neckImage?.draw(in: neckSize)
        hairImage?.draw(in: hairSize)
        
        
        //this is the finished drawing for the face
        let finishedImage  = UIGraphicsGetImageFromCurrentImageContext()
        //this must be called to close resource
        UIGraphicsEndImageContext()
        
        //create the rest of the cgsize which includes the rest of the body and combine the drawn face image
        
        let newSize = CGSize(width: 173, height: 185)
        let FaceRect = CGRect(x: 0, y: 33, width: 173, height: 173)
        let hairRect = self.gender == "boy" ? CGRect(x: 0, y: 0, width: 173, height: 128) : CGRect(x: 0, y: 25, width: 173, height: 165)
        
        UIGraphicsBeginImageContext(newSize)
        
        //draws image based on the gender

        if(self.gender == "boy")
        {
            finishedImage?.draw(in: FaceRect)
            hairImage?.draw(in: hairRect)
        }
        else
        {
            let topImage = hairImage?.cgImage?.cropping(to: CGRect(x: 0, y: 0, width: 173, height: 128/2))
            
            hairImage?.draw(in: hairRect)
            finishedImage?.draw(in: FaceRect)
            
            let topImage1 = UIImage(cgImage: topImage!)
            topImage1.draw(in: CGRect(x: 0, y: 5, width: 173, height: 60))
        }
        
        let fullFinishedImage = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()
        
        return fullFinishedImage!
    }
    func chooseFaceSizes(eyesSize1 : inout CGRect, eyesSize2 : inout CGRect,eyebrowsSize1 : inout CGRect, eyebrowsSize2 : inout CGRect, noseeSize : inout CGRect, mouthSize : inout CGRect)
    {

        //creates the cgsize for the face componets based on the choosen face size

        switch self.choosenFaceComplete
        {
        case 1:
            eyesSize1 = CGRect(x: 40, y: 50, width: 21, height: 31)
            eyesSize2 = CGRect(x: 105, y: 50, width: 21, height: 31)
            eyebrowsSize1 = CGRect(x: 33, y: 6, width: 45, height: 26)
            eyebrowsSize2 = CGRect(x: 98, y: 15, width: 45, height: 26)
            noseeSize = CGRect(x: 64, y: 74, width: 38, height: 33)
            mouthSize = CGRect(x: 74, y: 115, width: 37, height: 19)
        case 2:
            eyesSize1 = CGRect(x: 54, y: 49, width: 21, height: 31)
            eyesSize2 = CGRect(x: 104, y: 50, width: 21, height: 31)
            eyebrowsSize1 = CGRect(x: 34, y: 18, width: 45, height: 26)
            eyebrowsSize2 = CGRect(x: 97, y: 3, width: 45, height: 26)
            noseeSize = CGRect(x: 67, y: 74, width: 38, height: 33)
            mouthSize = CGRect(x: 76, y: 116, width: 37, height: 19)
        case 3:
            eyesSize1 = CGRect(x: 43, y: 49, width: 21, height: 31)
            eyesSize2 = CGRect(x: 110, y: 54, width: 21, height: 31)
            eyebrowsSize1 = CGRect(x: 32, y: 14, width: 45, height: 26)
            eyebrowsSize2 = CGRect(x: 101, y: 17, width: 45, height: 26)
            noseeSize = CGRect(x: 69, y: 70, width: 38, height: 33)
            mouthSize = CGRect(x: 65, y: 118, width: 37, height: 19)
        case 4:
            eyesSize1 = CGRect(x: 43, y: 36, width: 21, height: 31)
            eyesSize2 = CGRect(x: 105, y: 41, width: 21, height: 31)
            eyebrowsSize1 = CGRect(x: 34, y: 6, width: 45, height: 26)
            eyebrowsSize2 = CGRect(x: 102, y: 18, width: 45, height: 26)
            noseeSize = CGRect(x: 64, y: 53, width: 38, height: 33)
            mouthSize = CGRect(x: 74, y: 113, width: 37, height: 19)
        default:
            return
        }
    }
    func getMiddleImage() -> UIImage
    {
        gets and creates the arms and shirt of character


        let shirtImage = self.shirtsArray[self.choosenShirt!-1]
        let armImage = self.tintStuff[0]
        let handImage = self.tintStuff[1]
        let sideImage = self.shirtsSidesArray[self.choosenShirtSide!-1]
        
        
        
        let shirtSize = CGRect(x: 91, y: 0, width: 188, height: 203)
        let leftArmSize = CGRect(x: 0, y: 49, width: 120, height: 120)
        let rightArmSize = CGRect(x: 272, y: 49, width: 120, height: 120)
        let arms = getArmImages(hand: handImage, arm: armImage, side: sideImage)
        
        let entireSize = CGSize(width: 428, height: 203)
        
        UIGraphicsBeginImageContext(entireSize)
        
        arms.leftArmImage.draw(in: leftArmSize)
        arms.rightArmImage.draw(in: rightArmSize)
        shirtImage?.draw(in: shirtSize)
        
        let entireImage = UIGraphicsGetImageFromCurrentImageContext()
        
        UIGraphicsEndImageContext()
        
        return entireImage!
        
    }
    func getArmImages(hand : UIImage?, arm : UIImage?, side : UIImage?) -> (leftArmImage : UIImage , rightArmImage : UIImage)
    {

        //creates just the arms/hands sides and draws the image and returns the image


        let entireArmSize = CGSize( width: 120, height: 100)
        let armSize = CGRect(x: 0, y: 0, width: 83, height: 94)
        let handSize = CGRect(x: 57, y: 78, width: 42, height: 27)
        
        var sideSize: CGRect
        
        switch self.choosenShirtSide
        {
        case 1:
            sideSize = CGRect(x: 0, y: 0, width: 83, height: 94)
        case 2:
            sideSize = CGRect(x: 0, y: 0, width: 83, height: 70)
        case 3:
            sideSize = CGRect(x: 0, y: 0, width: 57, height: 61)
        default:
            sideSize = CGRect(x: 0, y: 0, width: 83, height: 94)
        }
        
        UIGraphicsBeginImageContext(entireArmSize)
        
        arm?.draw(in: armSize)
        side?.draw(in: sideSize)
        hand?.draw(in: handSize)
        
        let rightArm = UIGraphicsGetImageFromCurrentImageContext()
        
        UIGraphicsEndImageContext()
        
        let leftArm = UIImage(cgImage: (rightArm?.cgImage)!, scale: (rightArm?.scale)!, orientation: UIImageOrientation.upMirrored)
        
        return(leftArm, rightArm!)
        
    }
    func getPantsImage() -> UIImage
    {

        creates pants image from choosen values and returns an image

        let pantsSize = CGSize(width: 200, height: 330)
        
        let legImage = self.tintStuff[3]
        let pantsImage = self.pantsArray[self.choosenPants!-1]
        let shoesImage = self.shoesArray[self.choosenShoes!-1]
        let pantsBottomImage = self.pantsBottomArray[self.choosenPantsBottom!-1]
        
        let pantsBottomSize = CGRect(x: 0, y: 0, width: 200, height: 80)
        let rightLegSize = CGRect(x: 98, y: 49, width: 99, height: 245)
        let leftLegSize = CGRect(x: 0, y: 49, width: 99, height: 245)
        
        let legs = getLegsImage(bottom: pantsBottomImage!, leg: legImage!, pants: pantsImage!, shoes: shoesImage!)
        UIGraphicsBeginImageContext(pantsSize)
        
        legs.leftLeg.draw(in: leftLegSize)
        legs.rightLeg.draw(in: rightLegSize)
        pantsBottomImage?.draw(in: pantsBottomSize)
        
        let fullImage = UIGraphicsGetImageFromCurrentImageContext()
        
        UIGraphicsEndImageContext()
        
        return fullImage!
    }
    func getLegsImage(bottom : UIImage, leg : UIImage, pants : UIImage , shoes : UIImage) ->(leftLeg : UIImage, rightLeg : UIImage)
    {

        //gets the different ui images and combine the rest of them

        let legSize = CGSize(width: 100, height: 243)
        
        let tintLegSize = CGRect(x: 8, y: 12, width: 91, height: 178)
        let shoesSize = CGRect(x: 25, y: 152, width: 85, height: 65)
        var pantsSize : CGRect
        
        switch self.choosenPants
        {
        case 1:
            pantsSize = CGRect(x: 0, y: 0, width: 99, height: 190)
        case 2:
            pantsSize = CGRect(x: 0, y: 0, width: 99, height: 121)
        case 3:
            pantsSize = CGRect(x: 0, y: 0, width: 99, height: 90)
        default:
            pantsSize = CGRect(x: 0, y: 0, width: 99, height: 190)
        }
        
        UIGraphicsBeginImageContext(legSize)
        
        leg.draw(in: tintLegSize)
        pants.draw(in: pantsSize)
        shoes.draw(in: shoesSize)
        
        let rightLeg = UIGraphicsGetImageFromCurrentImageContext()
        let leftLeg = UIImage(cgImage: (rightLeg?.cgImage)!, scale: (rightLeg?.scale)!, orientation: UIImageOrientation.upMirrored)
        
        UIGraphicsEndImageContext()
        
        return(leftLeg,rightLeg!)
        
    }
    func getFullImage() -> UIImage
    {

        combines all the functions to get the character from top to bottom drawn

        let faceImg = self.ShowFaceImage()
        let middleImg = self.getMiddleImage()
        let bottomImg = self.getPantsImage()
        
        let faceSize = CGRect(x: 90, y: 0, width: 173, height: 185)
        let middleSize = CGRect(x: 35, y: 152, width: 328, height: 203)
        let legSize = CGRect(x: 105, y: 345, width: 145, height: 257)
        
        let entireSize = CGSize(width: 400, height: 600)
        
        UIGraphicsBeginImageContext(entireSize)
        
        bottomImg.draw(in: legSize)
        middleImg.draw(in: middleSize)
        faceImg.draw(in: faceSize)
        
        
        let entireImg = UIGraphicsGetImageFromCurrentImageContext()
        
        UIGraphicsEndImageContext()
        
        return entireImg!
        
        
        
    }
    func setChoosenDefaults()
    {
            //sets defaults for parameters

            self.chosenTint = 8
            self.choosenHairColor = 1
            self.choosenHair = 3
            self.choosenFaceComplete = 1
            self.choosenEyebrows = 1
            self.choosenEyes = 1
            self.choosenMouth = 1
            self.choosenNose = 1
            self.choosenShirtColor = 1
            self.choosenShirt = 1
            self.choosenShirtSide = 1
            self.choosenPantsColor = 1
            self.choosenPants = 1
            self.choosenPantsBottom = 1
            self.choosenShoesColor = 1
            self.choosenShoes = 1
            
    }
    
    // MARK: -  Load Image Arrays
    //these are functions for creating arrays and naming the image files right to use with array
    func preloadImageArrays()
    {

        tintArray = [1,2,3,4,5,6,7,8]
        hairColorArray = [1,2,3,4,5,6,7,8]
        pantsColorArray = [1,2,3,4,5,6,7,8,9,10,11,12]
        shirtsColorArray = [1,2,3,4,5,6,7,8]
        shoesColorArray = [1,2,3,4,5,6,7]
        
        addImageToArray(imageArray: &faceCompleteArray, string1: "face", string2: ".png", count: 4)
    }
    func loadFaceArrays()
    {
        setTintStuff()
        setEyebrowArray()
        setEyesArray()
        setMouthArray()
        setNoseArray()
        setHairArray()
    }
    func loadPantsArray()
    {
        setPantsAndBottomArray()
        setShoesArray()
        
    }
    func addImageToArray(imageArray : inout [UIImage?], string1 : String, string2 : String, count : Int)
    {
        imageArray.removeAll()
        
        var appendedString : String
        
        for i in 1...count
        {
            appendedString = String(format: "%@%d%@", string1, i, string2)
            imageArray.append(UIImage(named: appendedString))
            
        }
    }
    func addImageToArrayAlt(imageArray : inout [UIImage?], string1 : String, string2 : String, count : Int, color : String?)
    {
        imageArray.removeAll()
        
        var appendedString : String
        
        for i in 1...count
        {
            appendedString = String(format: "%@%@%d%@", color!, string1, i, string2)
            imageArray.append(UIImage(named: appendedString))
            
        }
    }
    func setEyebrowArray()
    {
        self.eyebrowsArray.removeAll()
        
        var colorString : String
        
        switch self.choosenHairColor
        {
        case 1:
            colorString = "black"
        case 2:
            colorString = "blonde"
            
        case 3:
            colorString = "brown1"
        case 4:
            colorString = "brown2"
        case 5:
            colorString = "grey"
        case 6:
            colorString = "red"
        case 7:
            colorString = "tan"
        case 8:
            colorString = "white"
        default:
            colorString = ""
        }
        addImageToArrayAlt(imageArray: &eyebrowsArray, string1: "Brow", string2: ".png", count: 3, color: colorString)
    }
    func setEyesArray()
    {
        self.eyesArray.removeAll()
        
        let colors :[String] = ["Black","Blue","Brown","Green","Pine"]
        
        for color in colors
        {
            let appendString = String(format: "eye%@_small.png", color)
            let appendString1 = String(format: "eye%@_large.png", color)
            
            self.eyesArray.append(UIImage(named: appendString))
            self.eyesArray.append(UIImage(named: appendString1))
        }
    }
    func setMouthArray()
    {
        self.mouthArray.removeAll()
        
        let mouthMoves :[String] = ["mouth_glad.png","mouth_happy.png","mouth_oh.png","mouth_sad.png","mouth_straight.png","mouth_teethLower.png","mouth_teethUpper.png",]
        
        for mouth in mouthMoves
        {
            self.mouthArray.append(UIImage(named: mouth))
        }
    }
    func setNoseArray()
    {
        self.noseArray.removeAll()
        
        for i in 1...3
        {
            let string1 = "tint"
            let string2 = "Nose"
            
            let imageString = String(format: "%@%d%@%d", string1,self.chosenTint! , string2 , i)
            self.noseArray.append(UIImage(named: imageString))
        }
    }
    func setHairArray()
    {
        self.hairArray.removeAll()
        let genderString = self.gender == "boy" ? "Man" : "Woman"
        let picCount = self.gender == "boy" ? 8 : 6
        var colorString : String
        
        switch self.choosenHairColor
        {
        case 1:
            colorString = "black"
        case 2:
            colorString = "blonde"
            
        case 3:
            colorString = "brown1"
        case 4:
            colorString = "brown2"
        case 5:
            colorString = "grey"
        case 6:
            colorString = "red"
        case 7:
            colorString = "tan"
        case 8:
            colorString = "white"
        default:
            colorString = ""
        }
        for i in 1...picCount
        {
            let imageString = String(format: "%@%@%d.png", colorString,genderString, i)
            self.hairArray.append(UIImage(named: imageString))
        }
    }
    func setPantsAndBottomArray()
    {
        self.pantsArray.removeAll()
        self.pantsBottomArray.removeAll()
        
        var colorString : String
        
        switch self.choosenPantsColor
        {
        case 1:
            colorString = "pantsBlue1"
        case 2:
            colorString = "pantsBlue2"
        case 3:
            colorString = "pantsBrown"
        case 4:
            colorString = "pantsGreen"
        case 5:
            colorString = "pantsGrey"
        case 6:
            colorString = "pantsLightBlue"
        case 7:
            colorString = "pantsNavy"
        case 8:
            colorString = "pantsPine"
        case 9:
            colorString = "pantsRed"
        case 10:
            colorString = "pantsTan"
        case 11:
            colorString = "pantsWhite"
        case 12:
            colorString = "pantsYellow"
        default:
            colorString = ""
            
        }
        
        let pantsStrings :[String] = ["_long.png","_short.png","_shorter.png"]
        
        for string in pantsStrings
        {
            let imageString = String(format: "%@%@", colorString,string)
            self.pantsArray.append(UIImage(named: imageString))
        }
        
        for i in 1...4
        {
            let imageString = String(format: "%@%d.png",colorString,i)
            self.pantsBottomArray.append(UIImage(named: imageString))
        }
    }
    func setShirtAndSidesArray()
    {
        self.shirtsArray.removeAll()
        self.shirtsSidesArray.removeAll()
        
        var colorString : String
        
        switch self.choosenShirtColor
        {
        case 1:
            colorString = "blue"
        case 2:
            colorString = "green"
        case 3:
            colorString = "grey"
        case 4:
            colorString = "navy"
        case 5:
            colorString = "pine"
        case 6:
            colorString = "red"
        case 7:
            colorString = "white"
        case 8:
            colorString = "yellow"
        default:
            colorString = ""
        }
        
        let armSidesStrings : [String] = ["Arm_long.png","Arm_short.png","Arm_shorter.png"]
        
        for string in armSidesStrings
        {
            let imageString = String(format: "%@%@", colorString, string)
            self.shirtsSidesArray.append(UIImage(named: imageString))
        }
        
        for i in 1...8
        {
            let imageString = String(format: "%@Shirt%d.png", colorString,i)
            self.shirtsArray.append(UIImage(named: imageString))
        }
    }
    func setShoesArray()
    {
        self.shoesArray.removeAll()
        
        var colorString : String
        
        switch self.choosenShoesColor
        {
        case 1:
            colorString = "black"
        case 2:
            colorString = "blue"
        case 3:
            colorString = "brown"
        case 4:
            colorString = "brown2"
        case 5:
            colorString = "grey"
        case 6:
            colorString = "red"
        case 7:
            colorString = "tan"
        default:
            colorString = ""
        }
        
        for i in 1...5
        {
            let imageString = String(format: "%@Shoe%d.png", colorString, i)
            self.shoesArray.append(UIImage(named: imageString))
        }
    }
    func setTintStuff()
    {
        self.tintStuff.removeAll()
        
        let imageArray :[String] = ["_arm.png","_hand.png","_head.png","_leg.png","_neck.png"]
        
        for string in imageArray
        {
            
            let imageString = String(format: "tint%d%@", self.chosenTint! ,string)
            self.tintStuff.append(UIImage(named: imageString))
        }
    }
    //MARK: -  Set Character Values functions
    //I use string value to convert and create the choosen value for the character
    func convertChoosenToCombinedFormat() -> String
    {
        let combinedString = String(format: "%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d," , self.chosenTint!, self.choosenNose!, self.choosenMouth!, self.choosenEyes!, self.choosenEyebrows!, self.choosenFaceComplete!, self.choosenHair!, self.choosenHair!, self.choosenHairColor!, self.choosenPants! , self.choosenPantsBottom!, self.choosenPantsColor! , self.choosenShoes!, self.choosenShoesColor!, self.choosenShirt!, self.choosenShirtSide!, self.choosenShirtColor!)
        
        return combinedString
    }
    func convertCombinedFormatToChoosen(combinedString : String)
    {
        
        let ArrayResult = combinedString.components(separatedBy: ",")
        
        //set the chosenValues
        self.chosenTint = Int(ArrayResult[0])
        self.choosenNose = Int(ArrayResult[1])
        self.choosenMouth = Int(ArrayResult[2])
        self.choosenEyes = Int(ArrayResult[3])
        self.choosenEyebrows = Int(ArrayResult[4])
        self.choosenFaceComplete = Int(ArrayResult[5])
        self.choosenHair = Int(ArrayResult[6])
        self.choosenHair = Int(ArrayResult[7])
        self.choosenHairColor = Int(ArrayResult[8])
        self.choosenPants = Int(ArrayResult[9])
        self.choosenPantsBottom = Int(ArrayResult[10])
        self.choosenPantsColor = Int(ArrayResult[11])
        self.choosenShoes = Int(ArrayResult[12])
        self.choosenShoesColor = Int(ArrayResult[13])
        self.choosenShirt = Int(ArrayResult[14])
        self.choosenShirtSide = Int(ArrayResult[15])
        self.choosenShirtColor = Int(ArrayResult[16])
        
        return;
    }
    func setCombinedToDefaults()
    {
        let combinedString = convertChoosenToCombinedFormat()
    
        var defaults = UserDefaults.standard
        defaults.set(combinedString, forKey: "combinedCharacterString")
    }
    
    
    
}