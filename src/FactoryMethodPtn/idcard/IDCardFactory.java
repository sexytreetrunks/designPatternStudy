package FactoryMethodPtn.idcard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FactoryMethodPtn.framework.Factory;
import FactoryMethodPtn.framework.Product;

public class IDCardFactory extends Factory{
    private Map<Integer, String> map = new HashMap<>();//대응표를 만들란게 뭔뜻인지 모르겠음 
    
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        int key_idnum = ((IDCard)product).getIdNum();
        String value_owner = ((IDCard)product).getOwner();
        map.put(key_idnum, value_owner);
    }

    public List getOwners() {
        return new ArrayList<String>(map.values());
    }
}
