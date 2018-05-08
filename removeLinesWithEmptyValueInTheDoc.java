import java.io.*;

class removeExtraImgLines{
    
    public static void main(String[] args) throws FileNotFoundException {
            String filePathRead = "./ToxicPlantJSON.json";
            String filePathWrite = "ToxicPlantJSON_update.json";
            BufferedReader br = null;
            BufferedWriter bw = null;
            try{
                 br = new BufferedReader(new InputStreamReader(new FileInputStream(filePathRead)));
                 bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathWrite)));
               } catch (IOException e) {
                   e.printStackTrace();
            } 
            
            String line1 = null;
            try{
             line1 = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int i = 0; 

            while (line1 != null){

                try{
                    if (line1.contains(",\"img")){
                        System.out.println("------------------------");
                        System.out.println(line1);
                        String line2 = br.readLine();
                        String line3 = br.readLine();
                        String value1 = line1.split(":")[1];
                        String value2 = line2.split(":")[1];
                        String value3 = line3.split(":")[1];
                        System.out.println(line2);
                        System.out.println(line3);
                        System.out.println("value1:"+value1+"  value2:"+value2+"  value3:"+value3);
                        

                        if (!value1.equals("\"\"") || !value2.equals("\"\"") || !value3.equals("\"\"")){
                            // if one of three line has values, then add them into the target files
                            bw.write(line1);
                            bw.write("\n");
                            bw.write(line2);
                            bw.write("\n");
                            bw.write(line3);
                            bw.write("\n");
                        } else {
                            System.out.println("skips three lines up+++++++");
                        }
                    }  else{
                        bw.write(line1);
                        bw.write("\n");
                    }
                    line1 = br.readLine();

                } catch (IOException e) {
                        e.printStackTrace();
                }  
            }
            try{
                bw.flush();
                br.close();
                bw.close();
                } catch (IOException e) {
                e.printStackTrace();
            }
    }
}