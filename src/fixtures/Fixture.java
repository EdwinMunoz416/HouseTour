/*
 * Step 1: Create Fixture class where everything is created from here!!!! *done
 * 
 * 	Everything created  needs a)name b)description
 */

package fixtures;

public class Fixture {
	
	// All objects created with have name and description
	private String name;
	private String descript;
	
public Fixture(String aName, String aDescript) {
		// constructors that takes in set name and set description
		this.name = aName;
		this.descript = aDescript;
	}
/*
 * Step 2: get/set name and description... 
 * --- Methods located here ---
 */

//get: operation to return name
// my getName method returns name
public String getName() {
		return name;
	}
// set: my set method w/ String parameter of aName..reads & changes value of name to aName
public void setName(String aName) {
		this.name = aName;
}
// get: operation to return description
public String getDescript() {
		return descript;
	}
// set: my set method w/ String parameter of aDescription..reads & changes value of descipt to aDescript
public void setDescript(String aDescript) {
		this.descript = aDescript;
	}
/*
 * All you need to keep creating!
 */
}
