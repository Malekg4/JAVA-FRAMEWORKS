
# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS
#

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
    Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required

For part C I went to the "mainscreen.html" file found in the template folder. There on line 19 I changed the shop name to "Malek's Computer Shop" and on lines 35-70 and 
100-135 I added different parts/ products for my customers shop. 

*-realized in part E that I wasn't supposed to input the 5 parts/ products in this step, so I deleted the html code and properly added the parts/ product in part E.-*
<hr>

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

For part D I started off by creating a simple about.html template in my template folder. In this template I created a simple about page for my customers company. Then I went back to my mainscreen
template and there right below my customers shop name I added an "About" button on line 22. However, this button doesn't work unless I added a controller. I so I went to my 
controller folder and added a new "AboutController" where I added the necessary tags such as "@Controller / @GetMapping" for my button on the main screen to work. The final step
was to go back to my about.html template and add another button on line 27 so users can go back and forth from the about page to the main screen. 
<hr>

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
    Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

For part E I went to the "BootStrapData.java" file and I used the commented out code as a sample to add my customers 5 parts/ products. However, I ran into a small roadblock
because I realized that everytime I ran my code I would get duplicates of the 5 parts/ product. To resolve this issue I simply created two variables partsCounter and productCounter
on lines 42-43. I set these variables to their respective repositories and used the ".count" method. I then put all my instances of the parts/ products in an if statement preventing
duplicate components being printed on my customer's website. 
<hr>

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:<br>
    •  The “Buy Now” button must be next to the buttons that update and delete products.<br>
    •  The button should decrement the inventory of that product by one. It should not affect the inventory of any associated parts.<br>
    •  Display a message that indicates the success or failure of a purchase<br>

For step F I started off by going back to the mainscreen.html file and added a "buy now" button on line 87. This was pretty simple to do since there was already an update and delete
button, I used that as an example and created the "buy now" button. Then I had to make a new controller that I called "BuyNowController" that not only decremented a products
inventory by 1 when the buy now button is clicked it also redirects to either a "purchase successful" or "purchase error" page. For that to work I needed to create two new 
templates that will prompt the customer with either message depending on if the product selected still has inventory. Both templates also provide a method to return back to
the main screen.

<hr>

G.  Modify the parts to track maximum and minimum inventory by doing the following:<br>
•  Add additional fields to the part entity for maximum and minimum inventory.<br>
•  Modify the sample inventory to include the maximum and minimum fields.<br>
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.<br>
•  Rename the file the persistent storage is saved to.<br>
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.<br>

For step G I started of by going to my Part.java file added a minInv and a maxInv fields on line 32. After that I made a constructor for my new fields and getter/ setters done 
in between lines 55 and 75. After that I went to my BootStrapData.java file and added max and min inventory values for all my different parts. This was pretty easy to do and was
done in between lines 67 and 77. Then I went to my templates folder and opened the InhousePartForm and OutsourcedPartForm. In both files I added text inputs for both 
max and min inventory. I based my code on the already existing fields for name, price, inv etc. Once I finished that I went to my file explorer and changed the name of my database
to "javaFrameworks" and also updated the name in my application.properties file in the resources folder so the names match. I then went back to the Part.java file and created a simple 
inventory validation method that returns a boolean value (true) if the inventory is a value in between the min and max values, it returns false otherwise. This method can be found at the 
bottom of the Part.java file on line 134. The last thing I did for this step wasFor both inhouse and outsourced part controller files, I added logic that uses the inventory validation method I 
created to generate an error message if the inventory is outside of range. This was conducted in an if statement between lines 44 and 50.

<hr>

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:<br>
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.<br>
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.<br>
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.<br>

<hr>

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

<hr>

J.  Remove the class files for any unused validators in order to clean your code.