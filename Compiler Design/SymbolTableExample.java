import java.util.*;

// Class to represent a symbol (variable or function)
class Symbol {
    String name;  // Name of the symbol
    String type;  // Type of the symbol (e.g., int, float)
    String scope; // Scope of the symbol (e.g., local, global)
    Object value; // Value associated with the symbol (if applicable)

    // Constructor for the symbol
    public Symbol(String name, String type, String scope, Object value) {
        this.name = name;
        this.type = type;
        this.scope = scope;
        this.value = value;
    }

    // Display the symbol information
    @Override
    public String toString() {
        return "Symbol{name='" + name + "', type='" + type + "', scope='" + scope + "', value=" + value + "}";
    }
}

// Class to represent the Symbol Table
class SymbolTable {
    private Map<String, Symbol> table; // A map to store symbols by their name

    // Constructor
    public SymbolTable() {
        this.table = new HashMap<>();
    }

    // Insert a symbol into the table
    public void insertSymbol(String name, String type, String scope, Object value) {
        if (!table.containsKey(name)) {
            Symbol symbol = new Symbol(name, type, scope, value);
            table.put(name, symbol);
            System.out.println("Inserted: " + symbol);
        } else {
            System.out.println("Symbol with name '" + name + "' already exists.");
        }
    }

    // Lookup a symbol by name
    public Symbol lookupSymbol(String name) {
        if (table.containsKey(name)) {
            return table.get(name);
        }
        return null;  // Return null if symbol not found
    }

    // Remove a symbol from the table
    public void removeSymbol(String name) {
        if (table.containsKey(name)) {
            table.remove(name);
            System.out.println("Removed symbol: " + name);
        } else {
            System.out.println("Symbol with name '" + name + "' does not exist.");
        }
    }

    // Display all symbols in the table
    public void displayTable() {
        System.out.println("Symbol Table:");
        for (Symbol symbol : table.values()) {
            System.out.println(symbol);
        }
    }
}

public class SymbolTableExample {
    public static void main(String[] args) {
        // Create a new Symbol Table
        SymbolTable symbolTable = new SymbolTable();

        // Insert some symbols into the table
        symbolTable.insertSymbol("x", "int", "local", 10);
        symbolTable.insertSymbol("y", "float", "global", 3.14);
        symbolTable.insertSymbol("z", "int", "local", 25);
        symbolTable.insertSymbol("sum", "function", "global", null);

        // Lookup a symbol
        Symbol symbol = symbolTable.lookupSymbol("x");
        if (symbol != null) {
            System.out.println("Found symbol: " + symbol);
        } else {
            System.out.println("Symbol not found.");
        }

        // Remove a symbol
        symbolTable.removeSymbol("z");

        // Display the current state of the symbol table
        symbolTable.displayTable();
    }
}
