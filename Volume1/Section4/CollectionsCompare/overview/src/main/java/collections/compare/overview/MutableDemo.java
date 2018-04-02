package collections.compare.overview;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.Stacks;

public class MutableDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Initializing mutable list with empty(), of(), with() method
		MutableList<String> mutableListEmpty =
		  Lists.mutable.empty();
		MutableList<String> mutableListOf =
		  Lists.mutable.of("One", "One", "Two", "Three");
		MutableList<String> mutableListWith =
		  Lists.mutable.with("One", "One", "Two", "Three");

		//Various container types available
		MutableSet<String> mutableSet =
		  Sets.mutable.with("One", "One", "Two", "Three");
		MutableBag<String> mutableBag =
		  Bags.mutable.with("One", "One", "Two", "Three");
		MutableStack<String> mutableStack =
		  Stacks.mutable.with("One", "One", "Two", "Three");
		MutableMap<String, String> mutableMap =
		  Maps.mutable.with("key1", "value1", "key2", "value2", "key3", "value3");
		MutableMultimap<String, String> multimapWithList =
		  Multimaps.mutable.list.with("key1", "value1-1", "key1", "value1-2", "key2","value2-1");
		MutableBiMap<String, String> mutableBiMap =
		  BiMaps.mutable.with("key1", "value1", "key2", "value2", "key3", "value3");

		System.out.println(mutableListEmpty);
		System.out.println(mutableListOf);
		System.out.println(mutableSet);
		System.out.println(mutableBag);
		System.out.println(mutableMap);
		mutableListEmpty.add("One");
		System.out.println(mutableListEmpty);
	}
}
