package utils;

import java.util.ArrayList;
import static com.app.core.Category.*;
import com.app.core.Pet;

public class CollectionUtils {

	public static ArrayList<Pet> populatedList(){
		
		ArrayList<Pet> list = new ArrayList<>();
		list.add(new Pet("ASD", DOG, 15000, 10));
		list.add(new Pet("QWE", CAT, 6240, 5));
		list.add(new Pet("JHD", CAT, 8500, 8));
		list.add(new Pet("PIJ", RABBIT, 2300, 7));
		list.add(new Pet("WEP", DOG, 18500, 5));
		list.add(new Pet("MKL", FISH, 700, 50));
		return list;
	}
}
