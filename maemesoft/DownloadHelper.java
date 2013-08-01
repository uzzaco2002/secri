package maemesoft;

//수정일 : 7/11 12:08 (현재 인벤토리 오류 수정중)

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

import maemesoft.db.DBHelper;

public class DownloadHelper {

	public static String readFile(String url) {
		try {
			byte[] array = new byte[4096];
			RTFEditorKit rtfParser = new RTFEditorKit();
			Document document = rtfParser.createDefaultDocument();
			rtfParser.read(new URL(url).openStream(), document, 0);
			return document.getText(0, document.getLength());
		} catch (Exception e) {
		}
		return null;
	}

	public static void downloadFile(String destination, String url) {
		try {
			System.out.println("Downloading " + destination);
			File destinationFile = new File(getDir(), destination);
			destinationFile.createNewFile();
			byte[] array = new byte[4096];
			DataInputStream urlStream = new DataInputStream(new URL(url).openStream());
			DataOutputStream fileStream = new DataOutputStream(new FileOutputStream(destinationFile));
			boolean var8 = false;

			do {
				int data;

				if ((data = urlStream.read(array)) < 0) {
					urlStream.close();
					fileStream.close();
					break;
				}

				fileStream.write(array, 0, data);
			} while (true);
			System.out.println("Downloaded " + destination);
		} catch (Exception e) {
			System.out.println("Failed to download " + destination);
		}
	}

	public static void downloadZip(File destination, String url) {
		try {
			URLConnection conn = new URL(url).openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("user-agent", "Pixelmon");
			InputStream in = conn.getInputStream();
			FileOutputStream out = new FileOutputStream(destination);

			byte[] b = new byte[1024];
			int count;

			while ((count = in.read(b)) > 0) {
				out.write(b, 0, count);
			}
			out.close();
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean compareVersion(String file, String url) {
		if (url == null)
			return true;
		try {
			long fileVersion = getChecksum(new FileInputStream(new File(getDir(), file)));
			long urlVersion = getChecksum(new URL(url).openStream());
			return fileVersion == urlVersion;
		} catch (Exception e) {
			return false;
		}
	}

	public static long getChecksum(InputStream is) {
		CheckedInputStream cis = null;
		long checksum = 0;
		try {
			cis = new CheckedInputStream(is, new Adler32());
			byte[] tempBuf = new byte[128];
			while (cis.read(tempBuf) >= 0) {
			}
			checksum = cis.getChecksum().getValue();
		} catch (IOException e) {
			checksum = 0;
		} finally {
			if (cis != null) {
				try {
					cis.close();
				} catch (IOException ioe) {
				}
			}
		}
		return checksum;
	}

	public static File getDir() {
		return Maeme.modDirectory;
	}

	private static String dbPath = null;

	public static String getDatabasePath() {
		if (dbPath != null)
			return dbPath;
		String databasePath = DownloadHelper.readFile(DBHelper.databaseURL);
		if (databasePath == null)
			return null;
		int startString = databasePath.indexOf("\n");
		if (startString != -1)
			databasePath = databasePath.substring(0, startString);
		dbPath = databasePath;
		return dbPath;
	}
}