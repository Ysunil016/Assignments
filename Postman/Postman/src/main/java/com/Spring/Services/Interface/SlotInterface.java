package com.Spring.Services.Interface;

import com.Spring.Bean.UserRecord;

/**
 * 
 * @author sunil016, Interface holds all the functions related to Slot Service
 *
 */

public interface SlotInterface {

	Object getAllAvailableSlots(String username);

	Object getAllBookedSlots(String username);

	boolean setSlotAvailable(String username, int slotNumber);

	boolean isSlotBooked(UserRecord userR, int slotNumber);

	boolean isSlotBooked(String username, int slotNumber);

	boolean isSlotAvailable(String username, int slotNumber);
}
