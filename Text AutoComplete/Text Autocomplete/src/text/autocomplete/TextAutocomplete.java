package text.autocomplete;

//Name:          ID:
//Antony Samir    (20171702015)
//Caroline Talaat (20171701074)
//Lydia George    (20171701080)

import text.autocomplete.ReadFile;
import forms.FileForm;
import forms.MainForm;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFrame;
import strings.EditDistance;
import strings.Prefix;
import static text.autocomplete.ReadFile.iterationsQuerie1;
import static text.autocomplete.ReadFile.value1;
import java.util.Arrays;
import java.util.Collections;

public class TextAutocomplete
{
    public static void main(String[] args) throws IOException
    {
        MainForm MF = new MainForm();
        MF.setVisible(true);
        MF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ReadFile RF = new ReadFile();
        
        RF.readMap();
        RF.readQueries1();
        RF.readQueries2();
        RF.readQueries3();

    }
}
