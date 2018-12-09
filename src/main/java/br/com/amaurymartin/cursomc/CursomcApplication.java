package br.com.amaurymartin.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.amaurymartin.cursomc.domain.Categoria;
import br.com.amaurymartin.cursomc.domain.Cidade;
import br.com.amaurymartin.cursomc.domain.Cliente;
import br.com.amaurymartin.cursomc.domain.Endereco;
import br.com.amaurymartin.cursomc.domain.Estado;
import br.com.amaurymartin.cursomc.domain.ItemPedido;
import br.com.amaurymartin.cursomc.domain.Pagamento;
import br.com.amaurymartin.cursomc.domain.PagamentoComBoleto;
import br.com.amaurymartin.cursomc.domain.PagamentoComCartao;
import br.com.amaurymartin.cursomc.domain.Pedido;
import br.com.amaurymartin.cursomc.domain.Produto;
import br.com.amaurymartin.cursomc.domain.enums.StatusPagamento;
import br.com.amaurymartin.cursomc.domain.enums.TipoCliente;
import br.com.amaurymartin.cursomc.repositories.CategoriaRepository;
import br.com.amaurymartin.cursomc.repositories.CidadeRepository;
import br.com.amaurymartin.cursomc.repositories.ClienteRepository;
import br.com.amaurymartin.cursomc.repositories.EnderecoRepository;
import br.com.amaurymartin.cursomc.repositories.EstadoRepository;
import br.com.amaurymartin.cursomc.repositories.ItemPedidoRepository;
import br.com.amaurymartin.cursomc.repositories.PagamentoRepository;
import br.com.amaurymartin.cursomc.repositories.PedidoRepository;
import br.com.amaurymartin.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	//SEÇÃO 2 AULA 24
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
	private ItemPedidoRepository ItemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Categoria cat1 = new Categoria().setNome("Informática");
		Categoria cat2 = new Categoria().setNome("Escritório");
		
		Produto p1 = new Produto().setNome("Computador").setPreco(2000.00);
		Produto p2 = new Produto().setNome("Impressora").setPreco(800.00);
		Produto p3 = new Produto().setNome("Mouse").setPreco(80.00);
		
		Estado est1 = new Estado().setNome("Minas Gerais");
		Estado est2 = new Estado().setNome("São Paulo");
		
		Cidade c1 = new Cidade().setNome("Uberlândia").setEstado(est1);
		Cidade c2 = new Cidade().setNome("São Paulo").setEstado(est2);
		Cidade c3 = new Cidade().setNome("Campinas").setEstado(est2);
		
		Cliente cli1 = new Cliente().setNome("Maria Silva").setEmail("maria@gmail.com")
									.setInscricaoFederal("36378912377").setTipo(TipoCliente.PESSOA_FISICA);
		
		Endereco e1 = new Endereco().setLogradouro("Rua Flores").setNumero("300")
									.setComplemento("Apto 303").setBairro("Jardim")
									.setCep("38220834").setCliente(cli1).setCidade(c1);
		Endereco e2 = new Endereco().setLogradouro("Avenida Matos").setNumero("105")
									.setComplemento("Sala 800").setBairro("Centro")
									.setCep("38777012").setCliente(cli1).setCidade(c2);
		
		Pedido ped1 = new Pedido().setData(sdf.parse("30/09/2017 10:32")).setCliente(cli1)
								  .setEnderecoEntrega(e1);
		Pedido ped2 = new Pedido().setData(sdf.parse("10/10/2017 19:35")).setCliente(cli1)
				  				  .setEnderecoEntrega(e2);
		
		Pagamento pagto1 = new PagamentoComCartao(StatusPagamento.CONFIRMADO.getCodigo(), ped1, 6);
		Pagamento pagto2 = new PagamentoComBoleto(StatusPagamento.PENDENTE.getCodigo(), ped2, sdf.parse("20/10/2017 04:20"), null);
		
		ItemPedido ip1 = new ItemPedido().setPedido(ped1).setProduto(p1).setQuantidade(1)
										 .setPreco(2000.00).setDesconto(0.00);
		ItemPedido ip2 = new ItemPedido().setPedido(ped1).setProduto(p3).setQuantidade(2)
				 						 .setPreco(80.00).setDesconto(0.00);
		ItemPedido ip3 = new ItemPedido().setPedido(ped2).setProduto(p2).setQuantidade(1)
				 						 .setPreco(800.00).setDesconto(100.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));	
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		ped1.setPagamento(pagto1);
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.setPagamento(pagto2);
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		this.produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		this.estadoRepository.saveAll(Arrays.asList(est1, est2));
		this.cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		this.clienteRepository.saveAll(Arrays.asList(cli1));
		this.enderecoRepository.saveAll(Arrays.asList(e1, e2));
		this.pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		this.pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		this.ItemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
	
}
