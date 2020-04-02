package strings;

//Name:          ID:
//Antony Samir    (20171702015)
//Caroline Talaat (20171701074)
//Lydia George    (20171701080)

public class EditDistance
{
    static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
        {
            return x;
        }
        if (y <= x && y <= z)
        {
            return y;
        } else
        {
            return z;
        }
    }

    public static int editDist(String str1, String str2, int m, int n)
    {//Using Dynamic Programming
        int dp[][] = new int[m + 1][n + 2]; // O(1)

        for (int i = 0; i <= m; i++)                                                 
        {//Ѳ(m)
            for (int j = 0; j <= n; j++)
            {//Ѳ(n)
                if (i == 0)
                {
                    dp[i][j] = j;
                } else if (j == 0)
                {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                } else
                {
                    dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
                    // Insert //Remove //Replace
                }
            }

        }
        return dp[m][n];
    }
}
