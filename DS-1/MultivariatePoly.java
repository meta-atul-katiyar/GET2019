
public class MultivariatePoly {
	int variableNum;
	Degree start = null, end;
	
	//list of Degree that contains list of coefficient and array of power variables
	static class Degree{
		int data;
		Degree nextDegree;
		Coefficient nextCoeff;
		
		Degree (int data, Coefficient coefficientObject){
			this.data = data;
			nextCoeff = coefficientObject;
			nextDegree = null;
		}
	}
	//list of coefficient and array of power of variables
	static class Coefficient{
		int[] varPowArray;
		int coeffValue;
		Coefficient next;
		
		Coefficient (int[] data, int coeffValue){
			this.varPowArray = data;
			this.coeffValue = coeffValue;
			next = null;
		}
	}
	
	MultivariatePoly(int n){
		variableNum = n;
	}
	/**
	 * @param mPoly
	 * @param coeffValue
	 * @param varPowArray
	 * @return nested list of multivariate polynomial
	 */
	public MultivariatePoly insert(MultivariatePoly mPoly, int coeffValue, int[] varPowArray){
		int degree = 0;
		for(int count = 0; count < mPoly.variableNum; count++){
			degree += varPowArray[count];
		}
		if(varPowArray.length != variableNum){
			throw new AssertionError("invalid coefficient array.");
		}
		else{
			Coefficient newCoefficient = new Coefficient(varPowArray, coeffValue);
			if(mPoly.start == null){
				Degree newDegree = new Degree(degree, newCoefficient);
				mPoly.start = newDegree;
			}
			else{
				Degree currDegree = mPoly.start;
				int flag = 0;
				while(currDegree.data != degree){
					currDegree = currDegree.nextDegree;
					if(currDegree == null){
						flag = 1;
						break;
					}
				}
				if(flag == 0){
					while(currDegree.nextCoeff.next != null){
						currDegree.nextCoeff = currDegree.nextCoeff.next;
					}
					currDegree.nextCoeff.next = newCoefficient;
				}
				else{currDegree = mPoly.start;
					while(currDegree.nextDegree != null){
						currDegree = currDegree.nextDegree;
					}
					Degree newDegree = new Degree(degree, newCoefficient);
					currDegree.nextDegree = newDegree;
				}
			}	
		}
		return mPoly;
	}

	/**
	 * @param mPoly
	 *  prints the polynomial
	 */
	public void printMPoly(MultivariatePoly mPoly){
		if(mPoly.start == null){
			throw new AssertionError("empty.");
		}
		else{
			Degree currDegree = mPoly.start;
			System.out.println("linked list:");
			while(currDegree != null){
				System.out.print(currDegree.data + "\t");
				while(currDegree.nextCoeff != null){
					int [] coeffArray = currDegree.nextCoeff.varPowArray;
					System.out.print(currDegree.nextCoeff.coeffValue+"[");
					for(int count=0; count < coeffArray.length; count++){
						System.out.print(coeffArray[count]+" ");
					}
					System.out.print("]\n\t");
					currDegree.nextCoeff = currDegree.nextCoeff.next;
				}
				System.out.println();
				currDegree = currDegree.nextDegree;
			}
		}
	}
	
	/**
	 * @param mPoly
	 * @return degree of polynomial
	 */
	public static int degreeOfPoly(MultivariatePoly mPoly){
		int polyDegree = 0;
		if(mPoly.start == null){
			throw new AssertionError("empty.");
		}
		else{
			Degree currDegree = mPoly.start;
			while(currDegree != null){
				if(polyDegree < currDegree.data){
					polyDegree = currDegree.data;
				}
				currDegree = currDegree.nextDegree;
			}
		}
		return polyDegree;
	}
	
	public static void main(String[]args){
		MultivariatePoly mPoly = new MultivariatePoly(4);
		mPoly.insert(mPoly, -3, new int[]{2,2,0,0});
		mPoly.insert(mPoly, 2,new int[]{2,2,2,2});
		mPoly.insert(mPoly, -9,new int[]{2,0,2,0});
		mPoly.insert(mPoly, 25, new int[]{0,0,0,0});
		
		mPoly.printMPoly(mPoly);
		
		System.out.println(degreeOfPoly(mPoly));
		
	}
}
