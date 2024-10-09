package com.example.api3;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Produtos")
public class produtoController {

    public produtoController() {
        adicionarProdutos();

    }

    ArrayList<Produtos> listaProdutos = new ArrayList<Produtos>();


    @GetMapping("/exibirProdutos")

    public ArrayList<Produtos> exibirProdutos() {
        return listaProdutos;
    }

    @GetMapping("/contarProdutos")
    public int contarProdutos() {
        return listaProdutos.size(); // aqui ele retorna a quantidade de elementos

    }


    @GetMapping("/apagarProdutos")
    public ArrayList<Produtos> apagarProdutos() {
        listaProdutos.clear();
        return listaProdutos;

    }

    private void adicionarProdutos(){
        Produtos produto1 = new Produtos();
        produto1.setId(1);
        produto1.setNome("Iphone 15 pro max");
        produto1.setPreco(7600);
        produto1.setCategoria("Eletronicos");
        listaProdutos.add(produto1);

        Produtos produto2 = new Produtos();

        produto2.setId(2);
        produto2.setNome("Iphone 14 pro max");
        produto2.setPreco(6000);
        produto2.setCategoria("Eletronicos");
        listaProdutos.add(produto2);

        Produtos produto3 = new Produtos();

        produto3.setId(3);
        produto3.setNome("Fone JBL");
        produto3.setPreco(450);
        produto3.setCategoria("Eletronicos");
        listaProdutos.add(produto3);

        Produtos produto4 = new Produtos();

        produto4.setId(4);
        produto4.setNome("Doritos");
        produto4.setPreco(14);
        produto4.setCategoria("Comidas");
        listaProdutos.add(produto4);

        Produtos produto5 = new Produtos();

        produto5.setId(5);
        produto5.setNome("Bad Boy 200ml");
        produto5.setPreco(450);
        produto5.setCategoria("Perfumes");
        listaProdutos.add(produto5);

        Produtos produto6 = new Produtos();

        produto6.setId(6);
        produto6.setNome("You200ml");
        produto6.setPreco(550);
        produto6.setCategoria("Perfumes");
        listaProdutos.add(produto6);

        Produtos produto7 = new Produtos();
        produto7.setId(7);
        produto7.setNome("Ursinho de pelucia");
        produto7.setPreco(120.50);
        produto7.setCategoria("Brinquedos");
        listaProdutos.add(produto7);

        Produtos produto8 = new Produtos();
        produto8.setId(8);
        produto8.setNome("Notebook Acer Nitro5");
        produto8.setPreco(8000);
        produto8.setCategoria("Eletronicos");
        listaProdutos.add(produto8);

        Produtos produto9 = new Produtos();
        produto9.setId(9);
        produto9.setNome("Carrinho de controle remoto");
        produto9.setPreco(270);
        produto9.setCategoria("Brinquedos");
        listaProdutos.add(produto9);

        Produtos produto10 = new Produtos();
        produto10.setId(10);
        produto10.setNome("Arsenal");
        produto10.setPreco(160);
        produto10.setCategoria("Perfumes");
        listaProdutos.add(produto10);

    }

    @GetMapping("/recarregarProdutos")
    public ArrayList<Produtos> recarregarProdutos() {  // este metodo verifica se a lista listaProdutos está vazia. Se estiver, ele chama o método exibirProdutos para preencher a lista com os produtos. e depois ele retorna a lista de produtos
        if (listaProdutos.isEmpty()) { // aqui esta verificando se a lista esta vazia
            adicionarProdutos(); // se estiver vazia ela chama o metodo e preenche a lista se estiver vazia

        }
        return listaProdutos;
    }



    @GetMapping("/produto/{id}") // O {id} é um parâmetro que será passado na URL, permitindo que o cliente especifique qual produto deseja buscar colocando o numero do id.
    public Produtos getProdutoPorId(@PathVariable int id) { // - O parâmetro @PathVariable int id significa que o método vai receber o valor do parâmetro id que foi definido na URL. Depois o Spring automaticamente irá pagar esse valor e passar para o método.
        for (Produtos produto : listaProdutos) {
            if (produto.getId() == id) { // - Aqui esta verificando se o ID do produto atual obtido através do método getId()) é igual ao id que foi passado como parâmetro por mim na URL.  Se a condição for verdadeira, significa que  encontramos o produto que estava sendo buscado.

                return produto; // Retorna o produto correspondente ao ID
            }
        }
        return null; // Retorna null se o produto não for encontrado
    }

    /*





3. **for (Produtos produto : listaProdutos) {**:
   - Inicia um loop que irá iterar sobre cada objeto produto na lista listaProdutos. Esta lista contém todos os produtos que você já adicionou anteriormente.
   - O loop permite que você examine cada produto na lista para encontrar aquele que corresponde ao ID fornecido.

4. **if (produto.getId() == id) {**:
   - Aqui está uma condição que verifica se o ID do produto atual (obtido através do método getId()) é igual ao id que foi passado como parâmetro na URL.
   - Se a condição for verdadeira, significa que encontramos o produto que o usuário está buscando.

5. **return produto;**:
   - Esta linha retorna o objeto produto que corresponde ao ID fornecido. Assim, o cliente que fez a requisição receberá os detalhes desse produto.

6. **}** (fechamento do bloco if):
   - Indica o fim do bloco de código que é executado se a condição do if for verdadeira.

7. **}** (fechamento do bloco for):
   - Indica o fim do loop que percorre a lista de produtos.

8. **return null;**:
   - Esta linha é executada se nenhum produto na lista corresponder ao ID fornecido. Retornar null indica que não foi encontrado nenhum produto correspondente.
   - Você pode optar por retornar um objeto de resposta mais informativo ou lançar uma exceção personalizada se preferir um tratamento de erro mais adequado (como um status 404).
     */

}



/*
    @GetMapping("/buscarProdutoId")
    public Produtos buscarProdutoId() { // ele retorna um objeto do tipo produto
        return listaProdutos.stream() // A lista de produtos que contem todos os produtos é convertida em stream, o .stream permite voce a usar operaçoes funcionais como o filter
                .filter(produto -> produto.getId() == 2)
                .findFirst()
                .orElse(null);
    }

    */