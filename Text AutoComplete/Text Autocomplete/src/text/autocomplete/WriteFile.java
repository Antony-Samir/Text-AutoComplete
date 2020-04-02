package text.autocomplete;

//Name:          ID:
//Antony Samir    (20171702015)
//Caroline Talaat (20171701074)
//Lydia George    (20171701080)

import forms.FileForm;
import forms.QuerieForm;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile
{

    static FileForm FF = new FileForm();
    static ReadFile RF = new ReadFile();
     
    static public int outputNum = 0;
   
    
    
    static public String outputVal = null;

    static FileWriter fwOutput = null;
    static PrintWriter pwOutput = null;

    public static void writeOutput1(String[] outputV, String[] outputW, int outputLength) throws IOException
    {
        try
        {
            
            fwOutput = new FileWriter("[1]Output.txt", true);
            pwOutput = new PrintWriter(fwOutput);

            outputNum = outputLength;
            pwOutput.println(outputNum);

            for (int i = 0; i < outputNum; i++)
            {
                outputVal = outputV[i];
                pwOutput.print(outputVal + " ");
                outputVal = outputW[i];
                pwOutput.println(outputVal);
                //FF.jTextArea1.setText(RF.weight1[i] + "    " + RF.value1[i] + "/n");
            }

            pwOutput.close();
            fwOutput.close();
            
        } catch (IOException e)
        {
            System.out.println("File El Output Not Found :'( ");
        }

    }

    public static void writeOutput2(String[] outputV, String[] outputW, int outputLength) throws IOException
    {
        try
        {
            fwOutput = new FileWriter("[2]Output.txt", true);
            pwOutput = new PrintWriter(fwOutput);

            outputNum = outputLength;
            pwOutput.println(outputNum);

            for (int i = 0; i < outputNum; i++)
            {
                outputVal = outputV[i];
                pwOutput.print(outputVal + " ");
                outputVal = outputW[i];
                pwOutput.println(outputVal);
            }

            pwOutput.close();
            fwOutput.close();
        } catch (IOException e)
        {
            System.out.println("File El Output Not Found :'( ");
        }

    }

    public static void writeOutput3(String[] outputV, String[] outputW, int outputLength) throws IOException
    {
        try
        {
            fwOutput = new FileWriter("[3]Output.txt", true);
            pwOutput = new PrintWriter(fwOutput);

            outputNum = outputLength;
            pwOutput.println(outputNum);

            for (int i = 0; i < outputNum; i++)
            {
                outputVal = outputV[i];
                pwOutput.print(outputVal + " ");
                outputVal = outputW[i];
                pwOutput.println(outputVal);
            }

            pwOutput.close();
            fwOutput.close();
        } catch (IOException e)
        {
            System.out.println("File El Output Not Found :'( ");
        }

    }
    
    public static void writeOutput4(String[] outputV, String[] outputW, int outputLength) throws IOException
    {
        try
        {
            fwOutput = new FileWriter("[4]Output.txt", true);
            pwOutput = new PrintWriter(fwOutput);

            outputNum = outputLength;
            pwOutput.println(outputNum);

            for (int i = 0; i < outputNum; i++)
            {
                outputVal = outputV[i];
                pwOutput.print(outputVal + " ");
                outputVal = outputW[i];
                pwOutput.println(outputVal);
            }

            pwOutput.close();
            fwOutput.close();
        } catch (IOException e)
        {
            System.out.println("File El Output Not Found :'( ");
        }

    }
    
    public static void writeOutput5(String[] outputV, String[] outputW, int outputLength) throws IOException
    {
        try
        {
            fwOutput = new FileWriter("[5]Output.txt", true);
            pwOutput = new PrintWriter(fwOutput);

            outputNum = outputLength;
            pwOutput.println(outputNum);

            for (int i = 0; i < outputNum; i++)
            {
                outputVal = outputV[i];
                pwOutput.print(outputVal + " ");
                outputVal = outputW[i];
                pwOutput.println(outputVal);
            }

            pwOutput.close();
            fwOutput.close();
        } catch (IOException e)
        {
            System.out.println("File El Output Not Found :'( ");
        }

    }
    
    public static void queryOutput(String[] outputV, String[] outputW, int outputLength) throws IOException
    {
        try
        {
            
            fwOutput = new FileWriter("OutPut Queries.txt", true);
            pwOutput = new PrintWriter(fwOutput);

            outputNum = outputLength;
            pwOutput.println(outputNum);

            for (int i = 0; i < outputNum; i++)
            {
                outputVal = outputV[i];
                pwOutput.print(outputVal + " ");
                outputVal = outputW[i];
                pwOutput.println(outputVal);
            }

            pwOutput.close();
            fwOutput.close();
            
        } catch (IOException e)
        {
            System.out.println("File El Output Not Found :'( ");
        }
    }

}
