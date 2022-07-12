package com.nagalakshmi.persistence;

public interface ProjectAllocationDao {

	boolean allocateProject(int empId, int projID);
	boolean deAllocateProject(int empId, int projID);
	boolean shiftToAProject(int empId, int projID);
}
