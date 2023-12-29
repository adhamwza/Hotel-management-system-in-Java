# Hotel-management-system-in-Java

# Background
The FIRE organisation manages a number of luxury resorts. Each resort consists of a group of small islands with a range of leisure facilities. Each island is connected by a ferry to one of more of the other islands of the resort. When guests arrive, they get a Pass (like a credit/debit card) which they can use for making payments at the resort. A Pass records a number of credits. We are concerned with using Passes to pay for ferry journeys. FIRE want to track people at their resorts and they have decided to use the Passes to do this. This project will be implemented at the Fortunate Islands Resort (then rolled out to other resorts).

# System Requirements
FIRE will locate people (guests and staff)  by tracking their Passes

A.	The following basic functional requirements have been established for the proposed system:
•	Display details of the whole resort
•	List all Passes on all islands of the resort and Passes currently on a specified island
•	Find the current location of a Pass
•	Authorise a ferry journey, if it meets the required conditions
•	Manage credits on a Pass, including convert journey points to credits

B.	The following data requirements have been established:
•	Pass – the resort has a collection of Passes used by people at the resort for travelling
Information stored on Passes includes: a Pass ID number, person's name, a luxury rating, a number of credits and journey points
The luxury rating (1 to 10) determines the islands which the person is allowed to visit e.g. a Pass with a rating of 3 is allowed to visit to all islands rated 3 or below. A Pass is created with an initial number of credits which are decremented when its owner makes a ferry journey. People may top up their credits at any time. 
Financial aspects of buying credits is outside the scope of this assignment

•	Island – a resort has a network of islands
Each island has an id number, a name, a rating and a capacity (the maximum number of people (Passes) that can be on the island at any one time). Each island should maintain a list of all Passes currently on that island. These lists should be updated whenever a Pass enters or leaves a island, so that it is always possible to say who is currently on a island and to find the island location of a person as specified by their Pass

•	Ferry journey– connects two islands of the resort
Each ferry journey has a journey code and connects a source island to a destination island. It represents a journey in one direction only. and there is a standard price of 3 credits for all  jouneys. To make a ferry journey, certain conditions must be met.  If these conditions are met, the system allows the person onto the ferry to travel to the destination island. It updates its records to show that a Pass has left the source island and has travelled to the destination island. It also updates the Pass's credits and other information, as appropriate. 

A request by someone(Pass) to make a ferry journey will produce one of the following results: 
•	Refusal to enter the ferry, because :
•	the Pass's luxury rating is lower than the rating of the destination island. 
•	the arrival of the Pass would exceed the maximum capacity of the destination island.
•	the Pass does not have enough credits for the ferry journey
•	the Pass is not listed in the source island for the ferry 
•	Successful entry, because none of the above conditions is true
•	Also, if either the Pass, or the ferry do not exist in the system, the journey will not be allowed 

•	Resort – implements the FIRE interface
Each resort has a network of islands joined by ferries. A resort must always have a “Base” island which stores the Passes for everyone who arrives. Its name MUST always be "Base" and it MUST have a rating of 0 and a large maximum capacity. All Passes registered at a resort are initially added to this “Base” island. 

# Assignment Tasks

# Task 1  - Implement and test the Pass class	
•	class Pass should have, at least:
•	the fields described above
•	a constructor to set all fields values, using either parameter values, or default values (see above)
•	accessors to return the Pass id, name, the luxury rating, number of credits 
•	methods to add/ deduct credits
•	method to use a ferry (deduct 3 credits and add 1 journey point) 
•	method to convert journey points to credits (5 journey points = 1 credit)
•	a toString() method returning a String with all  relevant information about the Pass
	
You may add further methods, if you consider them useful
•	class PassTester - which can be run to show that the Pass class works properly. It should:
•	create some suitable Pass objects 
•	and call their methods 
•	show that actual results are as expected

Note : you may add other methods if you consider it necessary.


# Task 2  - Implementing other lower level classes	
There is NO need to write tester classes for these classes, but do try BenchTesting to check they work.
•	class Island should have
•	an ArrayList field to store Pass object references. (declared and created)
•	a constructor to create an island using suitable parameters
•	accessors to return the island number, name, luxury rating and capacity
•	mutator enter() which has a Pass as a parameter and adds it to the ArrayList
•	mutator leave()which has a Pass as a parameter, finds its position in the ArrayList and then removes using this position.
•	an accessor which either says whether the island is full (reached capacity) (..or still has capacity)
•	method to list all the Passes currently on the island, 
•	methods to find and return details of one Pass in the island given its id
•	an accessor which returns a boolean saying whether a Pass is on the island (in the ArrayList)
•	a toString () method which includes island details and a list of the Passes on the island
This is a basic list of methods and you may need to add some more if required

•	class Ferry should include
•	Fields: ferry code, source island and a destination island to show its journey. These source/destination fields should be Island object.  
•	A constructor which required the ferry code and the source/destination island objects
•	A small range of accessors
•	method which returns a boolean saying if a Pass, given as a parameter, can travel on the ferry
•	a method to process a Pass travelling to the destination island;
•	if the pass meets the conditions, remove it from the source island, add it to the destination island and update information on the Pass, and return a suitable message
•	if it does not meet one of the conditions, return an appropriate message and do NOT move it
Note: do NOT attempt to check at this level whether a Pass or ferry is part of the system
•	a method toString()which returns a String representation of an object of that class including , room details and list of Passes 

Without these classes you will find it difficult to develop the remaining classes. You may add further fields/methods to these classes if you require them during further development 
VERY IMPORTANT NOTE: these lower level classes should NOT be using System.out.println()
.

# Task 3  - Implementing the Resort class 	
•	interface FIRE 
This class specifies methods required to provide system functionality.  A fully documented version of the FIRE is available in  Cwk3-students and you have NOTHING FURTHER to do in this class.   

	You must NOT change the signatures of any methods in the FIRE interface - you will be penalised
(except if required during the demonstration). 

•	class Resort - a skeleton of this class is included in Cwk3-students
•	is set up to implement the interface FIRE,. so do not change its header
•	we have prepared this class for you by copying the methods specified in the interface and providing code "stubs"  where you can write your code. 
•	declare and create three collections to store references to: all islands, all ferries & all Passes
•	the collection of all islands should be an Arraylist with positions of the island in the ArrayList are the same as its number i.e. Island 0 BASE should be in location 0 
•	the collections of Passes & ferries should also be Arraylist, but there are no assumptions about the order of objects
•	have a constructor which:
•	takes the name of the resort as a parameter.
•	sets the resort location from a parameter value (see constructor header)
•	it should then call two private methods, defined at the end of the class
•	loadIslandsAndFerries - which creates all the islands in Appendix A below, and adds them to the collection of islands. These should be added in the order of their id numbers. Then it also creates all ferries (passing island objects as parameters to their constructors) and adds them to the collection of ferries. 
•	loadPasses - should create all Passes and add them to the collection of Passes
•	finally, the constructor should add all of the Passes to the “Base” island
•	the class should then provide implementation for all methods specified in the interface  FIRE and listed in Resort
•	any additional methods which you may/should want to add to improve the design (but which are not specified in the interface) should be declared as private
•	 [3 private methods to return each type of object (ferry, Pass, island) may be useful] 
 
# Task 4 - Implementing an application		
•	class ResortUI 
	Provides a command line user interface to meet the functional requirements specified above.
It will compile (but not work well) even if you have not yet written the full implementation for Resort
•	some code has been provided, you must provide the code for the other menu options
•	you should use the  Scanner class to capture input from the user   
•	this class should only call methods specified in  FIRE 
Only this class and the Tester in Task 6 should use System.out.println


# Task 5 - System Testing	
You can test your code by running the ResortUI but you will eventually find this tedious.  So, we have provided a skeleton Tester class which:
•	declares a variable of  Resort class created as the Wayward Islands Resort.
•	already has a main() to make it runnable   (see ResortUI main()) -no need to do anything here
•	has  a doTest() method in which to write code to call methods on the FIRE variable in a way which tests your system and demonstrates it works according to specification. You should include appropriate output to the terminal window. You must also use comments to explain what is being tested.


We are looking for evidence of a systematic approach to testing and will expect you to show that you have identified and tested for the main events likely to occur when the system is running. At this stage, you may ignore the situation where a Pass visits an island but has insufficient credits to return to the "Base" island. 
# Task 6 - System Documentation	
•	a visually neat and readable UML-style class diagram of your system within the BlueJ project
•	program code should be well documented, displaying both agreed standards of internal documentation and good use of the facilities available in Javadoc. (FIRE & Resort are already well documented)
•	Tester class should be well documented (see above)


# Task 7 – Inheritance	
Provide the following subclasses which extend  the Pass class. 
All should have a toString() method which overrides toString() in Pass to include subclass data
•	Tourist Pass:
•	is created with a specified luxury rating and a number of credits determined by parameter values
•	deducts 4 credits whenever a ferry journey is made
•	also includes citizenship (country from which the person comes)

•	Business Pass
•	are created with a specified luxury rating, 30 credits and 20 loyalty points 
•	deduct 3 credits and add 2 loyalty points whenever a ferry journey is made
•	loyalty points can also be converted into credits (3 loyalty points = 1 credit)

•	Employee Pass 
•	are created with the highest luxury rating of 10 (Employees can visit all islands) and no credits
•	include an employee number, a job description, a journey score 
•	deduct zero credits for a journey, but add 1 to the journey score whenever a ferry journey is made

Now add an object of each class (using your own data) to the Passes in the Resort method loadPasses()and check the everything compiles and works for these objects


Appendix A:    Fortunate Islands Resort  - Islands & Ferries







Current Passes:
No.	Name	Rating	Credits
1000	Lynn	5	10
1001	May	3	30
1002	Nils	10	0
1003	Olek	1	12
1004	Pan	3	3
1005	Quin	1	30
1006	Raj 	4	5
1007	Sol	7	20
1008	Tel	6	30

These Passes have sequential ids, but they don't need to.   
