package ndev.design.readCodeBarre;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class ReadCodeBarreApplication  {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(ReadCodeBarreApplication.class, args);

		try {
			// Spécifiez le chemin de l'image contenant le code-barres
			File file = new File("C:\\Users\\Utilisateur\\Desktop\\projetSpring\\web\\readCodeBarre\\src\\main\\resources\\static\\icons\\code.jpg");

			// Lire l'image en BufferedImage
			BufferedImage bufferedImage = ImageIO.read(file);

			// Convertir l'image en une source de luminance utilisable par ZXing
			BufferedImageLuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

			// Créer un lecteur de code-barres
			MultiFormatReader barcodeReader = new MultiFormatReader();

			// Tenter de lire le code-barres
			Result result = barcodeReader.decode(binaryBitmap);

			// Afficher le texte du code-barres (ex: IMEI)
			System.out.println("Barcode text: " + result.getText());

		} catch (IOException e) {
			System.err.println("Error reading the image: " + e.getMessage());
		} catch (NotFoundException e) {
			System.err.println("No barcode found in the image.");
		}
	}
	}
