package collections.compare.overview;

import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.multimap.ImmutableMultimap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.Stacks;

public class ImmutableDemo {
	public static void main(String[] args) {
		//Initializing immutable list with empty(), of(), with() method
		ImmutableList<String> immutableListEmpty =
		  Lists.immutable.empty();
		ImmutableList<String> immutableListOf =
		  Lists.immutable.of("One", "One", "Two", "Three");
		ImmutableList<String> immutableListWith =
		  Lists.immutable.with("One", "One", "Two", "Three");

		//Various container types available
		ImmutableSet<String> immutableSet =
		  Sets.immutable.with("One", "One", "Two", "Three");
		ImmutableBag<String> immutableBag =
		  Bags.immutable.with("One", "One", "Two", "Three");
		ImmutableStack<String> immutableStack =
		  Stacks.immutable.with("One", "One", "Two", "Three");
		ImmutableMap<String, String> immutableMap =
		  Maps.immutable.with("key1", "value1", "key2", "value2", "key3", "value3");
		ImmutableMultimap<String, String> immutableMultimapWithList =
		  Multimaps.immutable.list.with("key1", "value1-1", "key1", "value1-2", "key2","value2-1");
		ImmutableBiMap<String, String> immutableBiMap =
		  BiMaps.immutable.with("key1", "value1", "key2", "value2", "key3", "value3");
		
		System.out.println(immutableListEmpty);
		System.out.println(immutableListOf);
		System.out.println(immutableSet);
		System.out.println(immutableBag);
		System.out.println(immutableMap);
		//immutableListEmpty.add("One"); // add method does not exist for immutable collections
	}
}
