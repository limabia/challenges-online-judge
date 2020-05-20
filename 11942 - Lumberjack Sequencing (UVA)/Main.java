import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int title;
                title = s.nextInt();
                if(title > 0 && title < 20){
                    int[][] lines = new int[title][10];
                    for(int j = 0; j < title; j++){
                        for(int i = 0; i < 10; i++){
                            lines[j][i] = s.nextInt();
                        }
                    }

                    System.out.println("Lumberjacks:");
                    int atual;
                    int posterior;
                    int terceiro;
                    boolean ordered = true;

                    for(int j = 0; j < title; j++){
                        for(int i = 0; i < 8; i++){
                            atual = lines[j][i];
                            posterior = lines[j][i+1];
                            terceiro = lines[j][i+2];
                            if(atual > posterior && posterior > terceiro){
                                ordered = true;
                            }
                            else if(atual < posterior && posterior < terceiro){
                                ordered = true;
                            }else{
                                ordered = false;
                                break;
                            }
                            
                        }

                        if(ordered) {
                            System.out.println("Ordered");
                        } else {
                            System.out.println("Unordered");
                        }
                    }
                }              
	}
}