/** @package 

        MaxReadBytesException.java
        
        Copyright(c) Solare Empire 2000
        
        Author: PORSCHE INFORMATIK GMBH
        Created: PIG 26.10.2005 20:35:24
*/
package com.hbedv.upload;
import java.io.IOException;

@SuppressWarnings("serial")
public class MaxReadBytesException extends IOException 
{
	long maxReadBytes;
	long contentLength;
	
	public MaxReadBytesException(long contentLength, long maxReadBytes)
	{
		super("Content length exceeded ("+contentLength+" > "+maxReadBytes+")");
		this.maxReadBytes = maxReadBytes;
		this.contentLength = contentLength;
	}

	public long getContentLength()
	{
		return this.contentLength;
	}
	
	public long getMaxReadBytes()
	{
		return this.maxReadBytes;
	}
}