/*
 * Step 3: Create Room constructor where the parameters for directions are assigned to integers 
 * for better navigating *done
 */
package fixtures;


public class Room extends Fixture{
	
	// exit directions
	private int n, s, w, e; 
	
	// This constructor method: called when we want to build a new room obj 
	public Room (String aName, String aDescript, int aN, int aS, int aW, int aE ){
		super(aName, aDescript); // init our superClass to give us N and D
		// methods
		this.n = aN;
		this.s = aS;
		this.w = aW;
		this.e = aE;
	}
		
	
	/*
	 *  Step 4: --accessor method-- 
	 *  
	 *  get / set private values for exits
	 *  
	 *  
	 *  get: operation to return 'n' no para
	 *  my getN method returns n 
	 */ 
	public int getN(){
		return n;
	}
	
	// set: no return
	// my set method assigns exit directions a value to be able to create a map
	public void setN(int aN) {
		this.n = aN;
	}
	
	/*
	 * repeat get/set methods
	 */
	
	public int getS() {
		return s;
	}
	public void setS(int aS) {
		this.s = aS;
	}
	public int getW() {
		return w;
	}
	public void setW(int aW) {
		this.w = aW;
	}
	public int getE() {
		return e;
	}
	public void setE(int aE) {
		this.e = aE;
	}
	
	
	
	
	
	
}