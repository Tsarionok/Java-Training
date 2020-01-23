package by.tsarionok.dao;


import by.tsarionok.entity.FoodType;
import by.tsarionok.entity.Guiding;
import by.tsarionok.entity.TransportType;
import by.tsarionok.entity.Voucher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;


public class TravelCompanyDao {

    private static final Logger LOGGER = LogManager.getLogger(TravelCompanyDao.class);
    private final static TravelCompanyDao INSTANCE = new TravelCompanyDao();
    private static Path dataBase;

    private TravelCompanyDao() {
        dataBase = Paths.get("dataBase/voucherBase.txt");
        try {
            if (Files.notExists(dataBase)) {
                Files.createFile(dataBase);
            }
        } catch (IOException ioException) {
            LOGGER.error("FileCreatingException");
        }
    }

    public static TravelCompanyDao getInstance() {
        return INSTANCE;
    }

    public void writeVoucher(TransportType transportType, FoodType foodType,
                             int dayAmount, Guiding guiding, double price) {

        List<String> voucherInfo = Arrays.asList(transportType.toString(),
                foodType.toString(),
                Integer.toString(dayAmount),
                guiding.toString(),
                Double.toString(price),
                "\n");
        try {
            Files.write(dataBase, voucherInfo, Charset.forName("UTF-8"), StandardOpenOption.APPEND);

        } catch (NullPointerException nullPointer) {
            LOGGER.error("NullPointerException");
        } catch (IOException ioException) {
            LOGGER.error("FileWritingException");
        }
    }

    public void writeVoucher(Voucher voucher) {
        writeVoucher(voucher.getTransportType(), voucher.getFoodType(), voucher.getDayAmount(),
                voucher.getGuiding(), voucher.getPrice());
    }

    public Voucher readVoucher() {
        try {

            Reader reader = Files.newBufferedReader(dataBase, Charset.forName("UTF-8"));
            String info = ((BufferedReader) reader).readLine();

            while (info != null) {
                System.out.println("Transport type: " + info);
                info = ((BufferedReader) reader).readLine();
                System.out.println("Food type: " + info);
                info = ((BufferedReader) reader).readLine();
                System.out.println("Amount of days: " + info);
                info = ((BufferedReader) reader).readLine();
                System.out.println("Vouchers type: " + info);
                info = ((BufferedReader) reader).readLine();
                System.out.println("Price: " + info);
                info = ((BufferedReader) reader).readLine();
                info = ((BufferedReader) reader).readLine();
                info = ((BufferedReader) reader).readLine();
                System.out.println();
            }
        } catch (IOException ioException) {
            LOGGER.error("FileReadingException");
        }
        return null;
    }
}
