import java.util.*;
public class MolecularMass{
     static void getCount(String str)
    {
 
        int intValue = 0;
        int mass=0;
        int tempMass=0;
        int groupExists=0;
        int elementCount=1;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                intValue = str.charAt(i);
                // i++;
            }else{

                if((str.charAt(i)) =='('){
                    groupExists = 1;
                }else{
                    if(Character.isDigit(str.charAt(i+1))){
                        elementCount = Character.getNumericValue(str.charAt(i+1));
                        // elementCount = elementCount * 10 + (str.charAt(i+1) - '0');
                            
                    }
                    if(groupExists == 1){
                        if((str.charAt(i)) == ')'){
                            groupExists = 0;
                            mass+=tempMass*elementCount;
                            tempMass= 0;
                            elementCount=1;
                        }else{
                            tempMass+=(getMolecularWeight(String.valueOf(str.charAt(i))))*elementCount;
                            
                        }
                    }
                    else {
                            
                        mass+=getMolecularWeight(String.valueOf(str.charAt(i)))*elementCount;
                        
                    }
                }
            }

            // try {
            //     Boolean flag = Character.isDigit(str.charAt(i));

			// 	intValue = Integer.parseInt(str.charAt(i));
			// 	i++;
			// } catch (NumberFormatException e) {
            //     try{
            //         elementMass = Integer.parseInt(str.charAt(i+1));
            //     }catch (NumberFormatException e) {
            //         System.out.println("in last else val"+elementMass);
            //     }
                
            // }
            
        }
            System.out.println(mass);

    }
        public static int getMolecularWeight(String element){
            if(element.equals("C")){
                return 12;
            }else if(element.equals("O")){
                return 16;
            }else if(element.equals("H")){
                return 1;
            }else if(element.equals("Fe")){
                return 55;
            }else{
                return 0;
            }
        }
 
    // Driver code
    public static void main(String[] args)
    {
        String str = "C(OH)2";
        System.out.println("Given molecule: "
                           + str);
        getCount(str);
        String str2 = "CHOC(CH3)3";
        System.out.println("Given molecule: "
                           + str2);
        getCount(str2);
    }
}