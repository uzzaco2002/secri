package maemesoft.storage;

//수정일 : 7/10 11:25 (현재 인벤토리 오류 수정중)

public class PlayerNotLoadedException extends Exception {
	public PlayerNotLoadedException() {
	}

	public PlayerNotLoadedException(String message) {
		super(message);
	}
}