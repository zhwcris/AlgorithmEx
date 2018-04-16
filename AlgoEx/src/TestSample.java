/**
 * Created by msp on 2017/11/13.
 */
import java.io.*;

public class TestSample {
    /**
     * Write the bytes from input stream to output stream.
     * The input stream and output stream are not closed.
     * @param is
     * @param os
     * @throws IOException
     */
    public  boolean copy(InputStream is, OutputStream os) throws IOException {
        int count = 0;
        //null pointer
        byte[] buffer = new byte[1024];
        while ((count = is.read(buffer)) >= 0) {
            os.write(buffer, 0, count);
        }
        //unclose i/o stream
        return true;
    }
    /**
     *
     * @param a
     * @param b
     * @param ending
     * @return copy the elements from a to b, and stop when meet element ending
     */
    public void copy(String[] a, String[] b, String ending)
    {
        int index;
        String temp = null;
        //null pointer exception
        if(temp != null){
            System.out.println(temp.length());
        }
        //unused variable
        for(index=0; index < a.length; index++)
        {
            //redundant if statement
            //should be equals
            if(temp != null && temp.equals(ending)){
                break;
            }
            //may out of bounds
            b[index] = temp;
        }
    }
    /**
     * @param file
     * @return file contents as string; null if file does not exist
     */
    public  void  readFile(File file) {

        try(InputStream is = new BufferedInputStream(new FileInputStream(file));
            OutputStream os = new ByteArrayOutputStream()
        ){
            copy(is,os);
        }
        catch (IOException e) {
            //stream not close
            e.printStackTrace();
        }
    }
}

