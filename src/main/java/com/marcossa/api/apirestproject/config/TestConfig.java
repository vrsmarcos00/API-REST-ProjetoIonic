package com.marcossa.api.apirestproject.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcossa.api.apirestproject.domain.Categoria;
import com.marcossa.api.apirestproject.domain.Cidade;
import com.marcossa.api.apirestproject.domain.Cliente;
import com.marcossa.api.apirestproject.domain.Endereco;
import com.marcossa.api.apirestproject.domain.Estado;
import com.marcossa.api.apirestproject.domain.ItemPedido;
import com.marcossa.api.apirestproject.domain.Pagamento;
import com.marcossa.api.apirestproject.domain.PagamentoComBoleto;
import com.marcossa.api.apirestproject.domain.PagamentoComCartao;
import com.marcossa.api.apirestproject.domain.Pedido;
import com.marcossa.api.apirestproject.domain.Produto;
import com.marcossa.api.apirestproject.domain.enums.EstadoPagamento;
import com.marcossa.api.apirestproject.domain.enums.TipoCliente;
import com.marcossa.api.apirestproject.repositories.CategoriaRepository;
import com.marcossa.api.apirestproject.repositories.CidadeRepository;
import com.marcossa.api.apirestproject.repositories.ClienteRepository;
import com.marcossa.api.apirestproject.repositories.EnderecoRepository;
import com.marcossa.api.apirestproject.repositories.EstadoRepository;
import com.marcossa.api.apirestproject.repositories.ItemPedidoRepository;
import com.marcossa.api.apirestproject.repositories.PagamentoRepository;
import com.marcossa.api.apirestproject.repositories.PedidoRepository;
import com.marcossa.api.apirestproject.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired 
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Cama");
		Categoria cat4 = new Categoria(null, "Mesa");
		Categoria cat5 = new Categoria(null, "Banho");
		Categoria cat6 = new Categoria(null, "Vestuário");
		Categoria cat7 = new Categoria(null, "Eletronicos");
		Categoria cat8 = new Categoria(null, "Eletrodomesticos");
		Categoria cat9 = new Categoria(null, "Papelaria");
		Categoria cat10 = new Categoria(null, "Perfumaria");
		Categoria cat11 = new Categoria(null, "Sabonete");
		Categoria cat12 = new Categoria(null, "Carro");
		Categoria cat13 = new Categoria(null, "Alimentos");
		Categoria cat14 = new Categoria(null, "Solidos");
		Categoria cat15 = new Categoria(null, "Embutidos");
		Categoria cat16 = new Categoria(null, "Enlatados");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11, cat12, cat13, cat14, cat15, cat16));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		
		Cidade c1 = new Cidade(null, "Campinas", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est1);
		Cidade c3 = new Cidade(null, "Uberlândia", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "000.000.000-00", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("61 0000-0000", "61 1111-1111"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", c3, cli1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777013", c2, cli1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, p1.getPreco());
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, p3.getPreco());
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, p2.getPreco());
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
