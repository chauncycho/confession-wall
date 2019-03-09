package chauncy.utility;

import org.junit.Test;

import java.util.UUID;

public class UUIDCreator {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }

    @Test
    public void uuidTest(){
        System.out.println(getUUID());
    }
}
