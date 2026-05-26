import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class BeneficiaryRepository {

    private final String filePath;
    private final Gson gson = new Gson();

    public BeneficiaryRepository(String filePath) {
        this.filePath = filePath;
        createFileIfNotExists();
    }

    public void append(Beneficiary beneficiary) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(gson.toJson(beneficiary));
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao adicionar beneficiário ao ficheiro.");
        }
    }

    public Beneficiary findById(int id) {
        Map<Integer, Beneficiary> beneficiaries = findAll();

        return beneficiaries.get(id);
    }

    public Map<Integer, Beneficiary> findAll() {
        Map<Integer, Beneficiary> beneficiaries = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Beneficiary beneficiary = gson.fromJson(line, Beneficiary.class);
                    beneficiaries.put(beneficiary.getId(), beneficiary);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler beneficiários do ficheiro.");
        }

        return beneficiaries;
    }
    public void clear() {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write("");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao limpar ficheiro JSON.");
        }
    }

    private void createFileIfNotExists() {
        try {
            File file = new File(filePath);

            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }

            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar ficheiro JSON.");
        }
    }
}   