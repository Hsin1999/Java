package demo02;
import java.io.File;

/**
 * 遍历打印指定目录下的所有文件及文件夹自文件
 */
public class PrintAllFile {
    private final File filepath;
    public PrintAllFile(String filepath){
        this.filepath=new File(filepath);
    }
    /**
     * 打印方法
     */
    public void print(){
        System.out.println(filepath.toPath().getFileName()+"/");
        click(filepath,1);
    }

    /**
     * 遍历检索文件和文件夹
     * @param file 文件路径
     * @param depth 文件深度
     */
    private static void click(File file, int depth){
        File[] files=file.listFiles();
        StringBuffer stringBuffer=depth(depth);
        if(files==null){
            return;
        }
        for(File f:files
        ){
            if (f.isFile()){
                System.out.println(stringBuffer.toString()+f.toPath().getFileName());
            }else{
                System.out.println(stringBuffer.toString()+f.toPath().getFileName()+"/");
                click(f,depth+1);
            }
        }
    }

    /**
     *
     * @param num 文件夹深度，default：1
     * @return 根据文件夹深度print文件前的空格数
     */
    private static StringBuffer depth(int num){
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0;i<num;i++){
            stringBuffer.append(" ");
        }
        return stringBuffer;
    }
}
