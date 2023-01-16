import java.util.Scanner;
import java.util.InputMismatchException;

public class FinalProject {
    private static int xWinCount=0;
    private static int oWinCount=0;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        char[][] arr = new char[3][3];
        int a,b;
        boolean check = true;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                arr[i][j] = ' ';
            }
        }
        printTable(arr);

        for(int m=0;m<9;m++){

            while (true) {
                try {
                    a = s.nextInt();
                    b = s.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    s.nextLine();
                }
            }

            while(a>3 || b>3){
                System.out.println("Coordinates should be from 1 to 3!");
                while (true) {
                    try {
                        a = s.nextInt();
                        b = s.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("You should enter numbers!");
                        s.nextLine();
                    }
                }
            }

            while(check){
                if(arr[a-1][b-1]=='X'||arr[a-1][b-1]=='O'){
                    System.out.println("This cell is occupied! Choose another one!");
                    while (true) {
                        try {
                            a = s.nextInt();
                            b = s.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("You should enter numbers!");
                            s.nextLine();
                        }
                    }
                    while(a>3 || b>3){
                        System.out.println("Coordinates should be from 1 to 3!");
                        while (true) {
                            try {
                                a = s.nextInt();
                                b = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("You should enter numbers!");
                                s.nextLine();
                            }
                        }
                    }
                }
                else
                    check = false;
            }

            if(arr[a-1][b-1]==' '){
                if(m%2==0) {
                    arr[a-1][b-1] = 'X';
                    printTable(arr);
                }
                else {
                    arr[a-1][b-1] = 'O';
                    printTable(arr);
                }
            }

            winningProbability(arr);
            if(xWinCount==1){
                System.out.println("X wins");
                break;
            }
            else if(oWinCount==1){
                System.out.println("O wins");
                break;
            }
            check = true;
        }
        if(xWinCount==0&&oWinCount==0)
            System.out.println("Draw");

    }

    static void printTable(char[][] arr){
        for(int i=0;i<9;i++)
            System.out.print("-");
        System.out.println();
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.print("|");
            System.out.println();
        }
        for(int i=0;i<9;i++)
            System.out.print("-");
        System.out.println();
    }

    static void winningProbability(char[][] arr){

        if(arr[0][0]==arr[1][0]){
           if(arr[1][0]==arr[2][0]) {
               if (arr[2][0] == 'X')
                   xWinCount += 1;
               else if(arr[2][0]=='O')
                   oWinCount += 1;
           }
        }
        if(arr[0][1]==arr[1][1]){
            if(arr[1][1]==arr[2][1]) {
                if (arr[2][1] == 'X')
                    xWinCount += 1;
                else if(arr[2][1]=='O')
                    oWinCount += 1;
            }
        }
        if(arr[0][2]==arr[1][2]){
            if(arr[1][2]==arr[2][2]) {
                if (arr[2][2] == 'X')
                    xWinCount += 1;
                else if(arr[2][2]=='O')
                    oWinCount += 1;
            }
        }
        if(arr[0][0]==arr[1][1]){
            if(arr[1][1]==arr[2][2]) {
                if (arr[2][2] == 'X')
                    xWinCount += 1;
                else if(arr[2][2]=='O')
                    oWinCount += 1;
            }
        }
        if(arr[0][0]==arr[0][1]){
            if(arr[0][1]==arr[0][2]) {
                if (arr[0][2] == 'X')
                    xWinCount += 1;
                else if(arr[0][2]=='O')
                    oWinCount += 1;
            }
        }
        if(arr[1][0]==arr[1][1]){
            if(arr[1][1]==arr[1][2]) {
                if (arr[1][2] == 'X')
                    xWinCount += 1;
                else if(arr[1][2]=='O')
                    oWinCount += 1;
            }
        }
        if(arr[2][0]==arr[2][1]){
            if(arr[2][1]==arr[2][2]) {
                if (arr[2][2] == 'X')
                    xWinCount += 1;
                else if(arr[2][2]=='O')
                    oWinCount += 1;
            }
        }
        if(arr[0][2]==arr[1][1]){
            if(arr[1][1]==arr[2][0]) {
                if (arr[2][0] == 'X')
                    xWinCount += 1;
                else if(arr[2][0]=='O')
                    oWinCount += 1;
            }
        }

    }

}

/*

Output:

---------
|       |
|       |
|       |
---------
2 2
---------
|       |
|   X   |
|       |
---------
2 2
This cell is occupied! Choose another one!
two two
You should enter numbers!
1 4
Coordinates should be from 1 to 3!
1 1
---------
| O     |
|   X   |
|       |
---------
3 3
---------
| O     |
|   X   |
|     X |
---------
2 1
---------
| O     |
| O X   |
|     X |
---------
3 1
---------
| O     |
| O X   |
| X   X |
---------
2 3
---------
| O     |
| O X O |
| X   X |
---------
3 2
---------
| O     |
| O X O |
| X X X |
---------
X wins

 */
