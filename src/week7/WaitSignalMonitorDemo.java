/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;
import java.util.concurrent.*;
/**
 *
 * @author ialsmadi
 */
public class WaitSignalMonitorDemo {
    private static WaitSignalMonitor mon = new WaitSignalMonitor();
	
	
	
	
	 public static void main (String [] args) {
              WaitSignalMonitorThread Num=null;
		 for (int i = 0; i <10; i ++) {
                     if(i % 2 == 0){
                     Num = new WaitSignalMonitorThread(mon, true, "print thread.."+ i);
                     }
                     else{
                       Num = new WaitSignalMonitorThread(mon, false, "print thread.."+ i);  
                     }
			
                         try{
                             
                         Num.t.join();}
                         catch(Exception ex){
                             
                         }
		 }
	 }
        
}
