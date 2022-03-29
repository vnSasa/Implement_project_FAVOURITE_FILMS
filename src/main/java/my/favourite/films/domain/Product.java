package my.favourite.films.domain;

public class Product {

	private Integer id;
	private String name;
	private String genre;
	private String alternativegenre;
	private String release;

	public Product(Integer id, String name, String genre, String alternativegenre, String release) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.alternativegenre = alternativegenre;
		this.release = release;
	}

	public Product(String name, String genre, String alternativegenre, String release) {
		super();
		this.name = name;
		this.genre = genre;
		this.alternativegenre = alternativegenre;
		this.release = release;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAlternativegenre() {
		return alternativegenre;
	}

	public void setAlternativegenre(String alternativegenre) {
		this.alternativegenre = alternativegenre;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternativegenre == null) ? 0 : alternativegenre.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((release == null) ? 0 : release.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (alternativegenre == null) {
			if (other.alternativegenre != null)
				return false;
		} else if (!alternativegenre.equals(other.alternativegenre))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", genre=" + genre + ", alternativegenre=" + alternativegenre
				+ ", release=" + release + "]";
	}

}
