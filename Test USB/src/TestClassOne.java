import org.usb4java.javax.*;
import javax.usb.*;
import org.usb4java.javax.adapter.*;
import org.usb4java.javax.descriptors.*;
import javax.usb.event.*;
import javax.usb.util.*;
import java.util.*;



public class TestClassOne {
	private int VendorID;
	private int ProductID;
	
	public TestClassOne(){
		VendorID = 0x461;
		ProductID = 0x4D03;
	}
	
	public UsbDevice findDevice(UsbHub hub, short vendorId, short productId)
	{
	    for (UsbDevice device : (List<UsbDevice>) hub.getAttachedUsbDevices())
	    {
	        UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
	        if (desc.idVendor() == vendorId && desc.idProduct() == productId) return device;
	        if (device.isUsbHub())
	        {
	            device = findDevice((UsbHub) device, vendorId, productId);
	            if (device != null) return device;
	        }
	    }
	    return null;
	}


}
