package co.edu.ucentral.DTO;

public class TransaccionesDTO {

	private int cus;
	private EstadoDTO estado;
	private ClienteDTO cliente;
	private String numeroCuentaDestino;
	private String numeroCuentaorigen;
	private String urlRetorno;
	private int banco;
	private double monto;
	private String descripcionPago;
	private ComercioDTO comercio;
	private String validar;
	private long idTxBanco;
	private int idFactura;

	public TransaccionesDTO() {

	}

	
	public TransaccionesDTO(int cus, EstadoDTO estado, ClienteDTO cliente, String numeroCuentaDestino,
			String numeroCuentaorigen, String urlRetorno, int banco, double monto, String descripcionPago,
			ComercioDTO comercio, String validar, long idTxBanco, int idFactura) {
		super();
		this.cus = cus;
		this.estado = estado;
		this.cliente = cliente;
		this.numeroCuentaDestino = numeroCuentaDestino;
		this.numeroCuentaorigen = numeroCuentaorigen;
		this.urlRetorno = urlRetorno;
		this.banco = banco;
		this.monto = monto;
		this.descripcionPago = descripcionPago;
		this.comercio = comercio;
		this.validar = validar;
		this.idTxBanco = idTxBanco;
		this.idFactura = idFactura;
	}


	public int getCus() {
		return cus;
	}

	public void setCus(int cus) {
		this.cus = cus;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public String getNumeroCuentaDestino() {
		return numeroCuentaDestino;
	}

	public void setNumeroCuentaDestino(String numeroCuentaDestino) {
		this.numeroCuentaDestino = numeroCuentaDestino;
	}

	public int getBanco() {
		return banco;
	}

	public void setBanco(int banco) {
		this.banco = banco;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getDescripcionPago() {
		return descripcionPago;
	}

	public void setDescripcionPago(String descripcionPago) {
		this.descripcionPago = descripcionPago;
	}

	public ComercioDTO getComercio() {
		return comercio;
	}

	public void setComercio(ComercioDTO comercio) {
		this.comercio = comercio;
	}

	public String getValidar() {
		return validar;
	}

	public void setValidar(String validar) {
		this.validar = validar;
	}

	public String getNumeroCuentaorigen() {
		return numeroCuentaorigen;
	}

	public void setNumeroCuentaorigen(String numeroCuentaorigen) {
		this.numeroCuentaorigen = numeroCuentaorigen;
	}

	public String getUrlRetorno() {
		return urlRetorno;
	}

	public void setUrlRetorno(String urlRetorno) {
		this.urlRetorno = urlRetorno;
	}

	public long getIdTxBanco() {
		return idTxBanco;
	}

	public void setIdTxBanco(long idTxBanco) {
		this.idTxBanco = idTxBanco;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	

}
