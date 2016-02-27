/*
 * Alexander Mark Thompson
 * CS350
 * Project #4
 * Description: This project uses Semaphores to produce a required design.
 */

import java.lang.Thread;
import java.util.concurrent.*;

public class ThreadSync
{
	private static Semaphore TrialA = new Semaphore(15);
	private static Semaphore TrialB = new Semaphore(0);
	private static Semaphore TrialC = new Semaphore(0);
    private static boolean runFlag = true;
	
    public static void main( String[] args ) {

        // create and start each runnable
        Runnable task1 = new TaskPrintC();
        Runnable task2 = new TaskPrintD();
        Runnable task3 = new TaskPrintP();

        Thread thread1 = new Thread( task1 );
        Thread thread2 = new Thread( task2 );
        Thread thread3 = new Thread( task3 );

        thread1.start();
        thread2.start();
        thread3.start();

        // Let them run for 500ms
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        // put up the stop sign
        runFlag=false;
 
        thread3.interrupt();
        thread2.interrupt();
        thread1.interrupt();
 
    }
    
    public static class TaskPrintC implements Runnable 
    {
        public void run(){
    	    while (runFlag) {
    	    	try{
    	    		TrialA.acquire(15);
    	    		System.out.printf( "%s\n", ":");
    	    	    TrialB.release(3);
    	    	}
    	    	catch(InterruptedException ex){
    	    		//ex.printStackTrace();
    	    	}
    	    }
        }
    }
    
    public static class TaskPrintD implements Runnable 
    {
        public void run(){
        	while (runFlag) {
        		try{
        			TrialB.acquire();
        			System.out.printf( "%s\n", "-");
        	        TrialC.release(5);
        		}
        		catch (InterruptedException ex){
        			//ex.printStackTrace();
        		}
    	    }
        }
    }
    
    public static class TaskPrintP implements Runnable 
    {
        public void run(){
    	    while (runFlag) {
    	    	try{
    	    		TrialC.acquire(3);
    	    		System.out.printf( "%s\n", ")");
        	        TrialA.release(3);
    	    	}
    	    	catch (InterruptedException ex){
    	    		//ex.printStackTrace();
    	    	}
    	    }
        }
    }

}
