package com.beecode.seeders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.beecode.entity.Banner;
import com.beecode.entity.Category;
import com.beecode.entity.Email;
import com.beecode.entity.Person;
import com.beecode.entity.Product;
import com.beecode.entity.ProductOnOffer;
import com.beecode.entity.ProductRating;
import com.beecode.entity.Product_picture;
import com.beecode.entity.Provider;
import com.beecode.entity.Role;
import com.beecode.entity.TopNotice;
import com.beecode.entity.User;
import com.beecode.entity.VerificationToken;
import com.beecode.repository.IBannerRepository;
import com.beecode.repository.ICategoryRepository;
import com.beecode.repository.IPersonRepository;
import com.beecode.repository.IProductOnOfferRepository;
import com.beecode.repository.IProductRepository;
import com.beecode.repository.IProviderRepository;
import com.beecode.repository.IRoleRepository;
import com.beecode.repository.ITopNoticeRepository;
import com.beecode.repository.IVerificationTokenRepository;
import com.beecode.service.SendingMailService;
import com.beecode.util.PasswordEncoder;

@Component
public class DataBase {

	private IRoleRepository roleRepo;
	@SuppressWarnings("unused")
	private SendingMailService sendingMailService;
	private IVerificationTokenRepository verficationTokenRepo;
	private IPersonRepository personRepo;
	private IProductRepository productRepo;
	private IProviderRepository providerRepo;
	private ICategoryRepository categoryRepo;
	private ITopNoticeRepository noticeRepo;
	private IBannerRepository bannerRepo;
	private IProductOnOfferRepository productOnOfferRepo;

	@Autowired
	public DataBase(IRoleRepository roleRepository, SendingMailService sendingMailService,
			IVerificationTokenRepository verficationTokenRepo, IPersonRepository personRepo,
			IProductRepository productRepo, IProviderRepository providerRepo, ICategoryRepository categoryRepo,
			ITopNoticeRepository noticeRepo, IBannerRepository bannerRepo,IProductOnOfferRepository productOnOfferRepo) {
		this.roleRepo = roleRepository;
		this.sendingMailService = sendingMailService;
		this.verficationTokenRepo = verficationTokenRepo;
		this.personRepo = personRepo;
		this.productRepo = productRepo;
		this.providerRepo = providerRepo;
		this.categoryRepo = categoryRepo;
		this.noticeRepo = noticeRepo;
		this.bannerRepo = bannerRepo;
		this.productOnOfferRepo = productOnOfferRepo;
	}

	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedTopNotice();
		seedRoleTable();
		seedPerson();
		seedCategory();
		seedProduct();
		seedBanner();
		seedProductOnOffer();
	}

	public void seedRoleTable() {
		ArrayList<Role> listRole = new ArrayList<>();
		Role roleUser = new Role(Role.ROLE_USER, "USER PRIVILEGES", true);
		Role roleAdmin = new Role(Role.ROLE_ADMIN, "ADMIN PRIVILEGES", true);
		Role roleSuperAdmin = new Role(Role.ROLE_SUPER_ADMIN, "SUPERADMIN PRIVILEGES", true);
		listRole.add(roleUser);
		listRole.add(roleAdmin);
		listRole.add(roleSuperAdmin);
		for (Role role : listRole) {
			Set<Role> roleExits = roleRepo.findByRoleName(role.getRoleName());
			if (roleExits.isEmpty()) {
				roleRepo.save(role);
			}
		}
	}

	public void seedPerson() {
		String email = "infobeecompany@gmail.com";
		try {
			List<VerificationToken> verificationTokens = verficationTokenRepo.findByUserEmailValue(email);
			VerificationToken verificationToken;
			if (verificationTokens.isEmpty()) {
				Person person = new Person();
				Set<Role> roles = roleRepo.findByRoleName(Role.ROLE_USER);

				person.setFirstName("Joel Ric");
				person.setLastName("Vargas Condori");
				person.setAddress("Villa Confraternindad Zona C1 Lt.2");
				person.setCity("Arequipa");
				person.setPhone("+51 983584715");
				person.setAge(23);
				person.setEmail(email);
				person.setPassword("123456789");
				person.setSex("Hombre");

				User user = new User();
				user.setEmail(new Email(person.getEmail()));
				user.setPassword(new PasswordEncoder(person.getPassword()));
				user.setStatus(true);
				user.setEnabled(false);
				user.setRoles(roles);

				verificationToken = new VerificationToken();
				verificationToken.setUser(user);
				user.setVerificationToken(verificationToken);

				person.setUser(user);

				personRepo.save(person);
				// sendingMailService.sendVerificationMail(email, verificationToken.getToken());
			}
		} catch (RuntimeException re) {
			re.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void seedProduct() {
		try {
			Optional<Product> optionalProduct = productRepo.findById((long) 1);
			Optional<Category> category = categoryRepo.findById((long) 1);
			String type;
			if (!optionalProduct.isPresent()) {
				for (int i = 0; i < 60; i++) {
					if(i%2 == 0) {
						type = Product.HOT_TYPE;
					}else if(i%3 == 0) {
						type = Product.NEW_TYPE;
					}else {
						type = Product.NORMAL_TYPE;
					}
					Product product = new Product();
					product.setName("Product example");
					product.setDescription("Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolre eu fugiat nulla pariatur "
							+ "excepteur sint occaecat cupidatat non. Duis aute irure dolor in reprehenderit in voluptate velit esse.");
					product.setUnitPrice(160.60);
					product.setSalePrice(200.60);
					product.setMSRP(180.60);
					product.setAvailableSize("150cm");
					product.setAvailableColor("#000, #FFF");
					product.setUnit_weight("20Kg");
					product.setDiscount(15);
					product.setStatusDiscount(true);
					product.setStock(15);
					product.setIVA(0);
					product.setType(type);
					product.setNote("Este es un producto de prueba");
					product.setPicturePrincipal("/assets/multimedia/images/database/product-1.jpg");
					product.setDomain("http://localhost:4200");
					
					//Picture
					product.setProduct_picture(seedProductPicture(product));
					product.setProvider(seedProvider().get(0));
					product.setCategory(category.get());
					
					//Rating
					ProductRating productRating= new ProductRating();
					Optional<Person> getUserById = personRepo.findById((long) 1);
					List<ProductRating> listProducRating = new ArrayList<ProductRating>();
					productRating.setScore(0);
					productRating.setUser(getUserById.get().getUser());
					productRating.setProduct(product);
					
					listProducRating.add(productRating);
					product.setProductRating(listProducRating);


					productRepo.save(product);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<Product_picture> seedProductPicture(Product product){
		List<Product_picture> products_picture = new ArrayList<>();
		Product_picture product_picture = new Product_picture();
		Product_picture product_picture2 = new Product_picture();
		Product_picture product_picture3 = new Product_picture();
		try {

			product_picture.setUrl("/assets/multimedia/images/database/product-1.jpg");
			product_picture.setDomain("http://localhost:4200");
			product_picture.setTag("Imagen de prueba");
			product_picture.setProduct(product);
			
			product_picture2.setUrl("/assets/multimedia/images/database/product-1.jpg");
			product_picture2.setDomain("http://localhost:4200");
			product_picture2.setTag("Imagen de prueba");
			product_picture2.setProduct(product);
			
			product_picture3.setUrl("/assets/multimedia/images/database/product-1.jpg");
			product_picture3.setDomain("http://localhost:4200");
			product_picture3.setTag("Imagen de prueba");
			product_picture3.setProduct(product);
			
			products_picture.add(product_picture);
			products_picture.add(product_picture2);
			products_picture.add(product_picture3);
			//products_picture.add(product_picture2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products_picture;
	}
	
	private List<Provider> seedProvider() {
		List<Provider> listProvider = null;
		try {
			listProvider = new ArrayList<Provider>();
			Provider provider = new Provider();
			provider.setCompany_name("Bee Company");
			provider.setContact_first_name("Joel Ric");
			provider.setContact_last_name("Vargas Condori");
			provider.setAddress1("Villa Confraternidad Zona A Mz C1");
			provider.setAddress2("Villa Confraternidad Zona A Mz C1");
			provider.setCity("Arequipa");
			provider.setState("LATAM");
			provider.setPostal_code("054");
			provider.setCountry("Arequipa");
			provider.setPhone("+51 983584715");
			provider.setEmail("infobeecompany@gmail.com");
			provider.setURL("https://www.facebook.com");
			provider.setPayment_methods("Contado");
			provider.setNote("Proveedor de ejemplo");
			provider.setLogo_url("/assets/images/products/product-1.jpg");
			provider.setDomain("http://localhost:4200");
			listProvider.add(provider);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProvider;
	}
	
	private void seedCategory() {
		Optional<Category> optionalCategory = categoryRepo.findById((long) 4);
		if(!optionalCategory.isPresent()) {
			ArrayList<Category> listCategory = new ArrayList<>();
			
			Category category1 = new Category();
			category1.setName("Standard Product");
			category1.setDescription("Esta es una categoria de ejemplo");
			category1.setStatus(true);
			
			Category category2 = new Category();
			category2.setName("Grouped Product");
			category2.setDescription("Esta es una categoria de ejemplo");
			category2.setStatus(true);

			Category category3 = new Category();
			category3.setName("Variable Product");
			category3.setDescription("Esta es una categoria de ejemplo");
			category3.setStatus(true);
			
			Category category4 = new Category();
			category4.setName("Virtual Product");
			category4.setDescription("Esta es una categoria de ejemplo");
			category4.setStatus(true);

			listCategory.add(category1);
			listCategory.add(category2);
			listCategory.add(category3);
			listCategory.add(category4);

			for (Category categories : listCategory) {
				categoryRepo.save(categories);
			}
		}
	}
	
	private void seedTopNotice() {
		Optional<TopNotice> optionalTopNotice = noticeRepo.findById((long) 1);
		if(!optionalTopNotice.isPresent()) {
			TopNotice topNotice = new TopNotice();
			topNotice.setDescription("Get Up to 40% OFF New-Season Styles Men");
			topNotice.setStatus(true);
			noticeRepo.save(topNotice);
		}
	}
	
	private void seedBanner() {
		Optional<Banner> optionalBanner = bannerRepo.findById((long) 2);
		Optional<Product> optionalProduct = productRepo.findById((long) 1);
		if(!optionalBanner.isPresent()) {
			Banner banner = new Banner();
			banner.setTitle("Banner de prueba");
			banner.setSubtitle("Encuentra el descuento");
			banner.setDescription("Banner de prueba");
			banner.setBannerUrl("/assets/multimedia/images/database/banner1.png");
			banner.setProduct(optionalProduct.get());
			banner.setDomain("http://localhost:4200");
			this.bannerRepo.save(banner);
		}	
	}
	
	private void seedProductOnOffer() {
		Optional<ProductOnOffer> optionalProductOnOffer = productOnOfferRepo.findById((long) 1);
		Optional<Product> optionalProduct = productRepo.findById((long) 1);
		if(!optionalProductOnOffer.isPresent()) {
			ProductOnOffer productOnOffer = new ProductOnOffer();
			productOnOffer.setDomain("http://localhost:4200");
			productOnOffer.setUrlImage("/assets/images/products/product-1.jpg");
			productOnOffer.setDescription("Lorem ipsum dolor sit amet, consectetuer "
					+ "adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.");
			productOnOffer.setStatus(true);
			productOnOffer.setProduct(optionalProduct.get());
			productOnOfferRepo.save(productOnOffer);
		}
	}
}
