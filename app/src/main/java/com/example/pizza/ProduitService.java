package com.example.pizza;


import com.example.pizza.classes.Produit;
import com.example.pizza.IDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    private static ProduitService INSTANCE;
    private final List<Produit> data = new ArrayList<>();

    private ProduitService() {
        seed(); // préremplissage
    }

    public static ProduitService getInstance() {
        if (INSTANCE == null) INSTANCE = new ProduitService();
        return INSTANCE;
    }

    private void seed() {
        data.add(new Produit("BARBECUED CHICKEN PIZZA", 3.0,
                com.example.pizza.R.drawable.pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves\n- 1 cup barbecue sauce...",
                "Pizza au poulet barbecue simple et rapide.",
                "STEP 1: Griller le poulet.\nSTEP 2: Garnir et cuire."));
        data.add(new Produit("SPINACH PIZZA", 2.0,
                com.example.pizza.R.drawable.pizza2, "25 min",
                "- Sauce Alfredo, épinards, tomates, fromage.",
                "Pizza crémeuse et légère aux légumes.",
                "STEP 1: Étaler la pâte.\nSTEP 2: Ajouter la garniture."));

        data.add(new Produit("SPINACH PIZZA", 2, R.drawable.pizza3, "25 min", "- 1 package (6-1/2 ounces) pizza crust mix\n- 1/2 cup Alfredo sauce\n- 2 medium tomatoes\n- 4 cups chopped fresh spinach\n- 2 cups shredded Italian cheese blend","This tasty pizza is so easy to prepare. My family, including my young daughter, loves it. What an easy way to make a delicious, veggie-filled meal! —Dawn Bartholomew, Raleigh, North Carolina","STEP 1:\n\n  Prepare pizza dough according to package directions. With floured hands, press dough onto a greased 12-in. pizza pan.\n\nSTEP 2:\n\n  Spread Alfredo sauce over dough to within 1 in. of edges. Thinly slice or chop tomatoes; top pizza with spinach, tomatoes and cheese.\n\nSTEP 3:\n\n  Bake at 450° for 10-15 minutes or until cheese is melted and crust is golden brown. Yield: 4-6 servings."));

        data.add(new Produit(
                "SEAFOOD DELIGHT PIZZA",
                6,
                R.drawable.pizza4,
                "40 min",
                "- 1 pizza crust\n- 200g shrimp\n- 150g calamari\n- 1/2 cup tomato sauce\n- 1 cup mozzarella\n- Garlic\n- Olive oil",
                "A delicious seafood pizza loaded with shrimp and calamari for ocean lovers.",
                "STEP 1: Cook seafood with garlic in olive oil.\n" +
                        "STEP 2: Spread sauce on crust.\n" +
                        "STEP 3: Add seafood and cheese.\n" +
                        "STEP 4: Bake at 200°C for 15 minutes."
        ));

        data.add(new Produit(
                "VEGGIE SUPREME PIZZA",
                4,
                R.drawable.pizza5,
                "30 min",
                "- Tomato sauce\n- Mushrooms\n- Bell peppers\n- Black olives\n- Onions\n- Mozzarella cheese",
                "Healthy and colorful vegetarian pizza packed with fresh vegetables.",
                "STEP 1: Spread tomato sauce.\n" +
                        "STEP 2: Add all vegetables evenly.\n" +
                        "STEP 3: Sprinkle cheese.\n" +
                        "STEP 4: Bake 12-15 minutes."
        ));

    }

    @Override
    public Produit create(Produit p) {
        data.add(p);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == p.getId()) {
                data.set(i, p);
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return data.removeIf(x -> x.getId() == id);
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : data) if (p.getId() == id) return p;
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return Collections.unmodifiableList(data);
    }
}