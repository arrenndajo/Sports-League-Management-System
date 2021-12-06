package Jprog;
import java.util.*;

class team {
    String name;
    int score_var = 0;
//TAKING INPUT FOR WINNNER OF MATCH AS IT WILL BE SAME FOR BOTH CASES
    String[][] result_of_match(HashSet<Set> set_match, team[] all_teams) {
        String result[][] = new String[all_teams.length][all_teams.length - 1];
        Scanner scan = new Scanner(System.in);
        String team_res = "";
        for (Set match_of : set_match) {
            int rom_iter = 0;
            String [] arr_teams=new String[2];
            for (Object in_match : match_of) {
                if (rom_iter == 0) {
                    System.out.print("\nTEAM THAT WON THE MATCH " + in_match + " VS ");
                }
                else {
                    System.out.print(in_match+"\n");
                }
                arr_teams[rom_iter++]=(String)in_match;
            }
            team_res = scan.next();
            team_res = team_res.toLowerCase();
            if (arr_teams[0].equals(team_res)){
                for (int i =0;i< all_teams.length;i++){
                    if (team_res.equals(all_teams[i].name)){
                        result[i][all_teams[i].score_var++]="W";
                    } }
                for (int i =0;i< all_teams.length;i++){
                    if (arr_teams[1].equals(all_teams[i].name)){
                        result[i][all_teams[i].score_var++]="L";
                    }

                }
            }
            if (arr_teams[1].equals(team_res)){
                for (int i =0;i< all_teams.length;i++){
                    if (team_res.equals(all_teams[i].name)){
                        result[i][all_teams[i].score_var++]="W";
                    } }
                for (int i =0;i< all_teams.length;i++){
                    if (arr_teams[0].equals(all_teams[i].name)){
                        result[i][all_teams[i].score_var++]="L";
                    }

                }

            }

            if (team_res.equals("draw")){
                for (Object draw_cond:match_of){
                    for (int i =0;i< all_teams.length;i++){
                        if (draw_cond.equals(all_teams[i].name)){
                            result[i][all_teams[i].score_var++]="D";
                        }

                    }
                }
            }

        }
        return result;
    }
}

public class Array {
    public static void main(String[] args) throws Exception
    {
// TAKING INPUT FROM USER
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER NAME OF THE LEAGUE");
        String leaguename = sc.next();
        System.out.println("ENTER NUMBER OF TEAMS:");
        int a = sc.nextInt();
        team teams[] = new team[a];
        team team_obj=new team();
        for (int i = 0; i < a; i++) {
            teams[i] = new team();
            System.out.println("ENTER NAME OF TEAM NO."+(i+1)+":");
            String tname = sc.next();
            teams[i].name = tname.toLowerCase();
        }
        System.out.println();
        System.out.println();
        Random randNum = new Random();
        Set<Integer>set = new LinkedHashSet<Integer>();
        int groups[]= new int[a];
        int ii=0;
        System.out.println("TYPE OF LEAGUE:\n 1.GROUPED LEAGUE\n 2.SINGLE LEAGUE ");
        int choice = sc.nextInt();
        switch(choice) {
            // FORMATION OF GROUPS
            case 1:{
                while (set.size() < a) {
                    set.add(randNum.nextInt(a));
                }

                for (int x:set) {
                    groups[ii++]=x;
                }
                System.out.println("NUMBER OF TEAMS IN A GROUP:");
                int teamno=sc.nextInt();
                int leastnum=a/teamno;
                String[][] grlist;
                int itervar=0;
                if(a%teamno==0) {// IF NO. OF TEAMS IN A GROUP ARE DIVISIBLE
                    grlist=new String[leastnum][teamno];
                    int numx=0;
                    for(int i=0;i<leastnum;i++) {
                        for(int j=0;j<teamno;j++) {
                            grlist[i][j]=teams[groups[numx]].name;
                            numx++;
                        }
                    }
                    System.out.println("-----------"+leaguename+"------------");
                    for(int i=0;i<leastnum;i++) {
                        System.out.println("----Group No."+(i+1)+"----");
                        for(int j=0;j<teamno;j++) {
                            System.out.println(grlist[i][j]);
                        }
                    }

                }
                else {// IF NO. OF TEAMS ARE NOT DIVISIBLE
                    grlist=new String[leastnum+1][teamno];
                    int numy=0;

                    for(int i=0;i<leastnum;i++) {
                        for(int j=0;j<teamno;j++) {
                            grlist[i][j]=teams[groups[numy]].name;
                            numy++;
                        }
                        itervar++;
                    }
                    for(int i =itervar;i<itervar+1;i++) {
                        for(int j=0;j<a%teamno;j++) {
                            grlist[i][j]=teams[groups[numy]].name;
                            numy++;
                        }
                    }
                    System.out.println("-----------"+leaguename+"------------");
                    for(int i=0;i<leastnum;i++) {
                        System.out.println("----group no."+(i+1)+"----");
                        for(int j=0;j<teamno;j++) {
                            System.out.println(grlist[i][j]);
                        }

                    }
                    for(int i =itervar;i<itervar+1;i++) {
                        System.out.println("----group no."+(i+1)+"----");
                        for(int j=0;j<a%teamno;j++) {
                            System.out.println(grlist[i][j]);
                        }
                    }
                }
                LinkedHashSet<LinkedHashSet<String>> x1 = new LinkedHashSet<LinkedHashSet<String>>();
                HashSet<Set>tot_match=new HashSet<Set>();
                Random Rnum= new Random();
// RANDOMLY ALLOTING TEAMS IN A GROUP
                for (int i=0;i<grlist.length;i++){
                    int num_match=0;

                    for(int k=grlist[i].length-1;k>0;k--){
                        num_match=num_match+k;
                    }
                    while(x1.size()<num_match){
                        int ran_num= Rnum.nextInt(grlist[i].length);
                        int ran_num2= Rnum.nextInt(grlist[i].length);
                        String t1=grlist[i][ran_num];
                        String t2=grlist[i][ran_num2];
                        if(ran_num!=ran_num2){
                            x1.add(new LinkedHashSet<String>(Arrays.asList(t1,t2)));
                        }
                        for (Set tset:x1){
                            tot_match.add(tset);
                            if (tset.contains(null)){
                                tot_match.remove(tset);
                            }
                        }
                    }
                    x1.clear();

                }
                int matchno=1;
                for (Set matches:tot_match){
                    int iter=0;
                    System.out.println("\nMATCH NO."+matchno++);
                    for(Object name_team:matches){
                        System.out.print(name_team);
                        if (iter==0){
                            System.out.print(" VS ");
                        }
                        iter++;
                    }
                }
                String[][] res_of_match =team_obj.result_of_match(tot_match,teams);
                if(a%teamno==0) {
                    System.out.println("-----------"+leaguename+"------------");
                    for(int i=0;i<leastnum;i++) {
                        System.out.println("\n----Group No."+(i+1)+"----");
                        for(int j=0;j<teamno;j++) {
                            System.out.print(grlist[i][j]+"\t");
                            for (int k=0;k<res_of_match.length;k++){
                                if (grlist[i][j].equals(teams[k].name)){
                                    for (int m=0;m<res_of_match[k].length;m++){
                                        if (res_of_match[k][m]!=null){
                                            System.out.print(res_of_match[k][m]);}
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    }
                }
                else {
                    System.out.println("-----------"+leaguename+"------------");
                    for(int i=0;i<leastnum;i++) {
                        System.out.println("----Group No."+(i+1)+"----");
                        for(int j=0;j<teamno;j++) {
                            System.out.print(grlist[i][j]+"\t");
                            for (int k=0;k<res_of_match.length;k++){
                                if (grlist[i][j].equals(teams[k].name)){
                                    for (int m=0;m<res_of_match[k].length;m++){
                                        if (res_of_match[k][m]!=null){
                                            System.out.print("\t"+res_of_match[k][m]);}
                                    }
                                    System.out.println();
                                }
                            }
                        }

                    }
                    for(int i =itervar;i<itervar+1;i++) {
                        System.out.println("----Group No."+(i+1)+"----");
                        for(int j=0;j<a%teamno;j++) {
                            System.out.print(grlist[i][j]+"\t");
                            for (int k=0;k<res_of_match.length;k++){
                                if (grlist[i][j].equals(teams[k].name)){
                                    for (int m=0;m<res_of_match[k].length;m++){
                                        if (res_of_match[k][m]!=null){
                                            System.out.print("\t"+res_of_match[k][m]);}
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    }
                }
                break;
            }
            //FORMATION OF SINGLE LEAGUE
            case 2:
                System.out.println("-----------"+leaguename+"-----------");
                for (int i = 0; i < a; i++) {
                    System.out.println(teams[i].name);
                }
                System.out.println("----------------------");
                Random num= new Random();
                HashSet<Set> x = new HashSet<Set>();
                int num_c2=0;
                for(int i=a-1;i>0;i--){
                    num_c2=num_c2+i;
                }
                while (x.size() <num_c2) {
                    int ran_num= num.nextInt(a);
                    int ran_num2= num.nextInt(a);
                    if(ran_num!=ran_num2){
                        x.add(new LinkedHashSet<String>(Arrays.asList(teams[ran_num].name,teams[ran_num2].name)));
                    }
                }
                int matchno=1;
                for (Set matches:x){
                    int iter=0;
                    System.out.println("\nMATCH NO."+matchno++);
                    for(Object name_team:matches){
                        System.out.print(name_team);
                        if (iter==0){
                            System.out.print(" VS ");
                        }
                        iter++;
                    }
                }
                String[][] res_of_match =team_obj.result_of_match(x,teams);
                System.out.println("-----------"+leaguename+"-----------");
                for (int i = 0; i < a; i++) {
                    System.out.print("\n"+teams[i].name);
                    for (int j=0;j<res_of_match[i].length;j++){
                        System.out.print("\t"+res_of_match[i][j]);
                    }
                }
                System.out.println("\n----------------------");
                break;
        }
    }}