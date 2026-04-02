package org.example.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.example.model.Endereco;
import org.example.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;

@Service
public class LeitorService {

    public List<Usuario> ler(MultipartFile file) {
        List<Usuario> usuarios = new ArrayList<>();

        try (InputStream is = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);

            // Começa da linha 1 (pula cabeçalho)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                String nome = get(row, 0);

                // Se não tem nome, ignora linha
                if (nome == null || nome.trim().isEmpty()) {
                    continue;
                }

                Usuario u = new Usuario();
                Endereco e = new Endereco();

                u.setNome(nome);
                u.setTelefone(get(row, 1));

                e.setLogradouro(get(row, 2));
                e.setCidade(get(row, 3));
                e.setNumero(get(row, 4));
                e.setCep(get(row, 5));
                e.setBairro(get(row, 6));

                u.setEndereco(e);

                usuarios.add(u);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler planilha: " + e.getMessage());
        }

        return usuarios;
    }

    private String get(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null) {
            return "";
        }

        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        }

        if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((long) cell.getNumericCellValue());
        }

        return "";
    }

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8082/myproject/api/v1/usuarios";

    public void enviar(List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            restTemplate.postForObject(URL, u, Usuario.class);
        }
    }
}
