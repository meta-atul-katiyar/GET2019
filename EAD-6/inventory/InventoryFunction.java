package inventory;

import java.util.*;

import java.util.concurrent.atomic.AtomicLong;

import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryFunction {
	// HashMap<String,Integer> inventoryList = new HashMap<String,Integer>();
	List<Item> inventoryList = new ArrayList<>();;

	/**
	 * @return array in json of items
	 */
	@GetMapping(produces = "application/json")
	public Object getAllItems() {
		for (int i1 = 0; i1 < inventoryList.size(); i1++) {
			Item ob = new Item();
			BeanUtils.copyProperties(inventoryList.get(i1), ob);
		}
		return new ResponseEntity<List<Item>>(inventoryList, HttpStatus.OK);
	}

	/**
	 * @param name
	 * @return item detail in json format
	 */
	@GetMapping("/{name}")
	public Item getItem(@PathVariable String name) {

		Item item = new Item();
		for (Item i : inventoryList) {
			if (i.getName().equals(name)) {
				item = i;
			}
		}
		return item;
	}

	/**
	 * @param itemList
	 * @return shows newly added objects
	 */
	@PutMapping("")
	public Object putAllItems(@RequestBody ArrayList<Item> itemList) {
		inventoryList.clear();
		inventoryList.addAll(itemList);
		return inventoryList;
	}

	/**
	 * @param item
	 * @param name
	 * @return show list with the recent modified object
	 */
	@PutMapping("/{name}")
	public Object putItem(@RequestBody Item item, @PathVariable String name) {

		for (Item i : inventoryList) {
			if (i.getName().equals(name)) {
				i.setQuantity(item.getQuantity());
			}
		}
		return inventoryList;
	}

	/**
	 * @param item
	 * @return return the list with new added item
	 */
	@PostMapping("")
	public Object postItem(@RequestBody Item item) {

		return inventoryList.add(item);
	}

	@DeleteMapping("")
	public Object deleteAllItems() {
		inventoryList.clear();
		return inventoryList;
	}

	@DeleteMapping("/{name}")
	public Object deleteItem(@PathVariable String name) {
		for (Item i : inventoryList) {
			if (i.getName().equals(name)) {
				inventoryList.remove(i);
			}
		}
		return inventoryList;
	}

}