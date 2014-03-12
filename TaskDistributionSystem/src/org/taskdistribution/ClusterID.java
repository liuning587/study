package org.taskdistribution;


import java.io.DataInput;
import java.io.DataOutput;
import java.util.concurrent.atomic.AtomicInteger;

import org.jgroups.Address;
import org.jgroups.util.Streamable;
import org.jgroups.util.Util;

public class ClusterID implements Streamable {
	private Address creator;
	private int id;
	private static AtomicInteger next_id = new AtomicInteger(1);

	public ClusterID() {
	}

	public ClusterID(Address paramAddress, int paramInt) {
		this.creator = paramAddress;
		this.id = paramInt;
	}

	public Address getCreator() {
		return this.creator;
	}

	public int getId() {
		return this.id;
	}

	public static ClusterID create(Address paramAddress) {
		return new ClusterID(paramAddress, next_id.incrementAndGet());
	}

	public int hashCode() {
		return (this.creator.hashCode() + this.id);
	}

	public boolean equals(Object paramObject) {
		ClusterID localClusterID = (ClusterID) paramObject;
		return ((this.creator.equals(localClusterID.creator)) && (this.id == localClusterID.id));
	}

	@Override
	public void readFrom(DataInput paramDataInputStream) throws Exception {
	    this.creator = Util.readAddress(paramDataInputStream);
	    this.id = paramDataInputStream.readInt();
	
	}

	@Override
	public void writeTo(DataOutput paramDataOutputStream) throws Exception {
	    Util.writeAddress(this.creator, paramDataOutputStream);
	    paramDataOutputStream.writeInt(this.id);
	}


}