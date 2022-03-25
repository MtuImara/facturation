package com.obr.facturation.jwt;

import java.util.Date;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.obr.facturation.services.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

//@Component
@Service
public class JwtUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	@Value("${com.obr.facturation.app.jwtSecret}")
	private String jwtSecret;
	@Value("${com.obr.facturation.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}
	
	 public String extractUsername(String token) {
	      return extractClaim(token, Claims::getSubject);
	  }
	  
	  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	      final Claims claims = extractAllClaims(token);
	      return claimsResolver.apply(claims);
	  }
	  
	  private Claims extractAllClaims(String token) {
	      return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	  }
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
	      final String username = extractUsername(token);
	      try {
	    	  return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	         // return true;
	        } catch (SignatureException e) {
	          logger.error("Invalid JWT signature: {}", e.getMessage());
	          System.out.println("Invalide JWT signature: {}");
	        } catch (MalformedJwtException e) {
	            System.out.println("Invalid JWT token: {}");
	          logger.error("Invalide JWT token: {}", e.getMessage());
	        } catch (ExpiredJwtException e) {
	            System.out.println("Invalid JWT expired: {}");
	          logger.error("JWT token est expiree: {}", e.getMessage());
	        } catch (UnsupportedJwtException e) {
	            System.out.println("Invalid JWT non supporte: {}");
	          logger.error("Invalid JWT non supporte: {}", e.getMessage());
	        } catch (IllegalArgumentException e) {
	            System.out.println("Invalid JWT est vide: {}");
	          logger.error("Invalid JWT est valide: {}", e.getMessage());
	        }
	      
	      return false;

	     
	  }
	  
	  private Boolean isTokenExpired(String token) {
	      return extractExpiration(token).before(new Date());
	  }
	  
	  public Date extractExpiration(String token) {
	      return extractClaim(token, Claims::getExpiration);
	  }

	
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}

}
