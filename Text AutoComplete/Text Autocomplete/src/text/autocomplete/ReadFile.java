package text.autocomplete;

//Name:          ID:
//Antony Samir    (20171702015)
//Caroline Talaat (20171701074)
//Lydia George    (20171701080)

import forms.FileForm;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import javax.swing.JOptionPane;

public class ReadFile
{

    public static FileForm IF = new FileForm();   
    
    public static String[] querieArray1;
    public static String[] querieArray2;
    public static String[] querieArray3;
    public static String[] querieArray4;
    public static String[] querieArray5;

    public static Integer iterationsMap1 = 0;
    public static Integer iterationsQuerie1 = 0;
    public static Integer iterationsMap2 = 0;
    public static Integer iterationsQuerie2 = 0;
    public static Integer iterationsMap3 = 0;
    public static Integer iterationsQuerie3 = 0;
    public static Integer iterationsQuerie4 = 0;
    public static Integer iterationsQuerie5 = 0;

    static FileReader frVal1;
    static BufferedReader brVal1;
    static FileReader frVal2;
    static BufferedReader brVal2;
    static FileReader frVal3;
    static BufferedReader brVal3;

    static FileReader frQuerie1;
    static BufferedReader brQuerie1;
    static FileReader frQuerie2;
    static BufferedReader brQuerie2;
    static FileReader frQuerie3;
    static BufferedReader brQuerie3;
    static FileReader frQuerie4;
    static BufferedReader brQuerie4;
    static FileReader frQuerie5;
    static BufferedReader brQuerie5;

    public static Long[] weight1;
    public static String[] value1;
    public static Long[] weight2;
    public static String[] value2;
    public static Long[] weight3;
    public static String[] value3;
    
    public static void readMap() throws IOException
    {//read file and set map
////////////////////////////////////////////////////EASYYYYYYYYYY////////////////////////////////////////////////////        
        try                                                      
        {//read file                                             
            frVal1 = new FileReader("[1]Data.txt");              
            brVal1 = new BufferedReader(frVal1);                 
        } catch (Exception ex)                                   
        {//catch exception file not found                        
            System.out.println("File Not Found!!");              
        }                                                        
        iterationsMap1 = Integer.parseInt(brVal1.readLine().toString()); 
        if (iterationsMap1 == 0)                                 
        {                                                        
            System.out.println("File is emptyyyyy");             
        }                                                        
        String sentence1;                                        
        String[] parts1 = new String[2];                         
        weight1 = new Long[iterationsMap1];                
        value1 = new String[iterationsMap1];                 
                                                                 
        for (int i = 1; i < iterationsMap1 + 1; i++)             
        {                                                        
            sentence1 = brVal1.readLine();                       
            parts1 = sentence1.split(" ");                       
            weight1[i - 1] = Long.parseLong(parts1[0].toString());                
            value1[i - 1] = parts1[1].toString();                
        }                                                        
        brVal1.close();                                          
        frVal1.close();                                          
                                                                 
        /*for (int i = 1; i < iterationsMap1 + 1; i++)             
         {//to check for the input data                          
         //System.out.println(weight1[i-1]);                       
         System.out.println(value1[i-1]);
         }*/                                                        
////////////////////////////////////////////////////EASYYYYYYYYYY////////////////////////////////////////////////////        

////////////////////////////////////////////////////MEDUIMMMMMMMM////////////////////////////////////////////////////        
        try                                                      
        {//read file                                             
            frVal2 = new FileReader("[2]Data.txt");              
            brVal2 = new BufferedReader(frVal2);                 
        } catch (Exception ex)                                   
        {//catch exception file not found                        
            System.out.println("File Not Found!!");              
        }                                                        
        iterationsMap2 = Integer.parseInt(brVal2.readLine().toString()); 
        if (iterationsMap2 == 0)                                 
        {                                                        
            System.out.println("File is emptyyyyy");             
        }                                                        
        String sentence2;                                        
        String[] parts2 = new String[2];                         
        weight2 = new Long[iterationsMap2];                
        value2 = new String[iterationsMap2];                 
                                                                 
        for (int i = 1; i < iterationsMap2 + 1; i++)             
        {                                                        
            sentence2 = brVal2.readLine();                       
            parts2 = sentence2.split(" ");                       
            weight2[i - 1] = Long.parseLong(parts2[0].toString());                
            value2[i - 1] = parts2[1].toString();                
        }                                                        
        brVal2.close();                                          
        frVal2.close();                                          
                                                                 
        /*for (int i = 1; i < iterationsMap2 + 1; i++)             
         {//to check for the input data                          
         //System.out.println(weight2[i-1]);                       
            System.out.println(value2[i-1]);
         }*/                                                       
////////////////////////////////////////////////////MEDUIMMMMMMMM////////////////////////////////////////////////////   
      
////////////////////////////////////////////////////HARDDDDDDDDDD////////////////////////////////////////////////////        
        try                                                      
        {//read file                                             
            frVal3 = new FileReader("[3]Data.txt");              
            brVal3 = new BufferedReader(frVal3);                 
        } catch (Exception ex)                                   
        {//catch exception file not found                        
            System.out.println("File Not Found!!");              
        }                                                        
        iterationsMap3 = Integer.parseInt(brVal3.readLine().toString());        
        if (iterationsMap3 == 0)                                 
        {                                                        
            System.out.println("File is emptyyyyy");             
        }                                                        
        String sentence3;                                        
        String[] parts3 = new String[2];                         
        weight3 = new Long[iterationsMap3];                
        value3 = new String[iterationsMap3];                 
                                                                 
        for (int i = 1; i < iterationsMap3 + 1; i++) 
        {                                                        
            sentence3 = brVal3.readLine();                       
            parts3 = sentence3.split(" ", 2);                       
            weight3[i - 1] = Long.parseLong(parts3[0].toString());                
            value3[i - 1] = parts3[1].toString();                
        }                                                        
        brVal3.close();                                          
        frVal3.close();                                          
                                                                 
        /*for (int i = 1; i < iterationsMap3 + 1; i++)             
         {//to check for the input data                          
            System.out.println(weight3[i-1]);                       
            System.out.println(value3[i-1]);
         }*/                                                       
////////////////////////////////////////////////////HARDDDDDDDDDD////////////////////////////////////////////////////
    }

    
    
////////////////////////////////////////////////////Querie-EASYYYYYYYYYY////////////////////////////////////////////////////        
    public static void readQueries1() throws IOException
    {//read queries file 
        try
        {//read file
            frQuerie1 = new FileReader("[1]Queries.txt");
            brQuerie1 = new BufferedReader(frQuerie1);
        } catch (Exception ex)
        {//catch exception file not found
            System.out.println("File Not Found!!");
        }
        iterationsQuerie1 = Integer.parseInt(brQuerie1.readLine().toString());
        if (iterationsQuerie1 == 0)
        {
            System.out.println("File is emptyyyyy");
        }
        querieArray1 = new String[iterationsQuerie1];
        for (int i = 0; i < iterationsQuerie1; i++)
        {
            querieArray1[i] = brQuerie1.readLine().toString();
        }
        brQuerie1.close();
        frQuerie1.close();

        /*for (int i = 0; i < iterationsQuerie1; i++)
        {//to check for the input data
            System.out.println(querieArray1[i]);
        }*/
    }
////////////////////////////////////////////////////Querie-EASYYYYYYYYYY////////////////////////////////////////////////////
    
////////////////////////////////////////////////////Querie-MEDUIMMMMMMMM////////////////////////////////////////////////////        
    public static void readQueries2() throws IOException
    {
        try
        {//read file
            frQuerie2 = new FileReader("[2]Queries.txt");
            brQuerie2 = new BufferedReader(frQuerie2);
        } catch (Exception ex)
        {//catch exception file not found
            System.out.println("File Not Found!!");
        }
        iterationsQuerie2 = Integer.parseInt(brQuerie2.readLine().toString());
        if (iterationsQuerie2 == 0)
        {
            System.out.println("File is emptyyyyy");
        }
        querieArray2 = new String[iterationsQuerie2];
        for (int i = 0; i < iterationsQuerie2; i++)
        {
            querieArray2[i] = brQuerie2.readLine().toString();
        }
        brQuerie2.close();
        frQuerie2.close();

        /*for (int i = 0; i < iterationsQuerie2; i++)
        {//to check for the input data
            System.out.println(querieArray2[i]);
        }*/
    }
////////////////////////////////////////////////////Querie-MEDUIMMMMMMMM////////////////////////////////////////////////////
    
////////////////////////////////////////////////////Querie-HARDDDDDDDDDD////////////////////////////////////////////////////        
    public static void readQueries3() throws IOException
    {
        try
        {//read file
            frQuerie3 = new FileReader("[3]Queries.txt");
            brQuerie3 = new BufferedReader(frQuerie3);
        } catch (Exception ex)
        {//catch exception file not found
            System.out.println("File Not Found!!");
        }
        iterationsQuerie3 = Integer.parseInt(brQuerie3.readLine().toString());
        if (iterationsQuerie3 == 0)
        {
            System.out.println("File is emptyyyyy");
        }
        querieArray3 = new String[iterationsQuerie3];
        for (int i = 0; i < iterationsQuerie3; i++)
        {
            querieArray3[i] = brQuerie3.readLine().toString();
        }
        brQuerie3.close();
        frQuerie3.close();

        /*for (int i = 0; i < iterationsQuerie3; i++)
        {//to check for the input data
            System.out.println(querieArray3[i]);
        }*/
    }
////////////////////////////////////////////////////Querie-HARDDDDDDDDDD////////////////////////////////////////////////////
    
////////////////////////////////////////////////////Querie-MEDUIMMMMMMMM222////////////////////////////////////////////////////        
    public static void readQueries4() throws IOException
    {
        try
        {//read file
            frQuerie4 = new FileReader("[4]Queries.txt");
            brQuerie4 = new BufferedReader(frQuerie4);
        } catch (Exception ex)
        {//catch exception file not found
            System.out.println("File Not Found!!");
        }
        iterationsQuerie4 = Integer.parseInt(brQuerie4.readLine().toString());
        if (iterationsQuerie4 == 0)
        {
            System.out.println("File is emptyyyyy");
        }
        querieArray4 = new String[iterationsQuerie4];
        for (int i = 0; i < iterationsQuerie4; i++)
        {
            querieArray4[i] = brQuerie4.readLine().toString();
        }
        brQuerie4.close();
        frQuerie4.close();

        /*for (int i = 0; i < iterationsQuerie4; i++)
        {//to check for the input data
            System.out.println(querieArray4[i]);
        }*/
    }
////////////////////////////////////////////////////Querie-MEDUIMMMMMMMM222////////////////////////////////////////////////////
    
////////////////////////////////////////////////////Querie-HARDDDDDDDDDD222////////////////////////////////////////////////////        
    public static void readQueries5() throws IOException
    {
        try
        {//read file
            frQuerie5 = new FileReader("[5]Queries.txt");
            brQuerie5 = new BufferedReader(frQuerie5);
        } catch (Exception ex)
        {//catch exception file not found
            System.out.println("File Not Found!!");
        }
        iterationsQuerie5 = Integer.parseInt(brQuerie5.readLine().toString());
        if (iterationsQuerie5 == 0)
        {
            System.out.println("File is emptyyyyy");
        }
        querieArray5 = new String[iterationsQuerie5];
        for (int i = 0; i < iterationsQuerie5; i++)
        {
            querieArray5[i] = brQuerie5.readLine().toString();
        }
        brQuerie5.close();
        frQuerie5.close();

        /*for (int i = 0; i < iterationsQuerie5; i++)
        {//to check for the input data
            System.out.println(querieArray5[i]);
        }*/
    }
////////////////////////////////////////////////////Querie-HARDDDDDDDDDD222////////////////////////////////////////////////////

}