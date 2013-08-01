package maemesoft.common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import maemesoft.enums.EnumMovement;

public class PacketCreator {
	public static Packet250CustomPayload createPacket(EnumPackets epacket, int i) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);
		Packet250CustomPayload packet = new Packet250CustomPayload();
		try {
			data.writeInt(epacket.getIndex());
			data.writeInt(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		packet.channel = "Pixelmon";
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;
		return packet;
	}

	public static Packet createPacket(EnumPackets epacket, int i1, int i2) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);
		Packet250CustomPayload packet = new Packet250CustomPayload();
		try {
			data.writeInt(epacket.getIndex());
			data.writeInt(i1);
			data.writeInt(i2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		packet.channel = "Pixelmon";
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;
		return packet;
	}

	public static Packet250CustomPayload createPacket(EnumPackets epacket, int i1, int i2, int i3) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);
		Packet250CustomPayload packet = new Packet250CustomPayload();
		try {
			data.writeInt(epacket.getIndex());
			data.writeInt(i1);
			data.writeInt(i2);
			data.writeInt(i3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		packet.channel = "Pixelmon";
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;
		return packet;
	}

	public static Packet250CustomPayload createStringPacket(EnumPackets epacket, int i1, String s1) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);
		Packet250CustomPayload packet = new Packet250CustomPayload();
		try {
			data.writeInt(epacket.getIndex());
			data.writeInt(i1);
			Packet.writeString(s1, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		packet.channel = "Pixelmon";
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;
		return packet;
	}

	public static Packet250CustomPayload createStringPacket(EnumPackets epacket, String s1) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);
		Packet250CustomPayload packet = new Packet250CustomPayload();
		try {
			data.writeInt(epacket.getIndex());
			Packet.writeString(s1, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		packet.channel = "Pixelmon";
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;
		return packet;
	}

	public static Packet createPacket(EnumPackets epacket, EnumMovement[] movements) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);
		Packet250CustomPayload packet = new Packet250CustomPayload();
		try {
			data.writeInt(epacket.getIndex());
			data.writeShort(movements.length);
			for (int i = 0; i < movements.length; i++) {
				data.writeShort(movements[i].index);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		packet.channel = "Pixelmon";
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;
		return packet;
	}

	public static Packet createPacket(EnumPackets epacket) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(bytes);
		Packet250CustomPayload packet = new Packet250CustomPayload();
		try {
			data.writeInt(epacket.getIndex());
		} catch (IOException e) {
			e.printStackTrace();
		}
		packet.channel = "Pixelmon";
		packet.data = bytes.toByteArray();
		packet.length = packet.data.length;
		return packet;
	}
}