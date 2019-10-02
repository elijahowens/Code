package commonExam2Practice;

	import java.util.Scanner;
	//import java.util.Arrays;


	public class BookLibrary1 {

		
		
		public static void main(String[] args) {
			
			int books = 0;
			
			Scanner input = new Scanner(System.in);
			Book library[] = new Book[10];
			
			
			
			String choice = "";
			System.out.println("Enter one of the following options: \n a --> to add a book \n d --> to delete a book \n c --> to change a book's information \n q --> to quit \n After completing the function, continue choosing the options.");
			while(choice != "q")
			{
				
				choice = input.nextLine();
				
				if(choice.equals("a")){
					
					if(library.length == books){
						System.out.println("Too many books. Try taking a book out or replacing one.");
						continue;
					}
					if(library.length != books)
						System.out.println("What is the name of the book?");
						String title = input.nextLine();
						System.out.println("How many pages were in the book?");
						int pages = input.nextInt();
					
					Book book = new Book(pages, title);
					
					for(int i = 0; i < library.length; i++)
						if(library[i] == null){
							library[i] = book;
							books++;
							System.out.println("Book added.\nTitle: "+library[i].getTitle()+"\nPages: "+library[i].getPages()+"\nNumber of books: "+books);	
							
							break;
					
						}
					 
					
					
					}
				
					
				else if(choice.equals("d")){
					if(library.length == 0)
						System.out.println("Can't take out a book that was never there! Try adding one first.");
					
					if(library.length != 0)
					System.out.println("What book do you want to delete?");
					String deleteBook = input.nextLine();
				
					for(int i = 0; i < library.length; i++)
					{
						
						if (library[i] == null){
							break;
							}
						
						
						String t = library[i].getTitle();
						
						if(t.equals(deleteBook))
						{
							
							library[i] = null;
							books--;
							System.out.println("Book deleted.\nNumber of books: "+books);
							break;
						
						}
						if(!t.equals(deleteBook))
							System.out.println("Book does not exist. Try again.");
							
							break;	
							
							
							
						}
					
					}
					
								
				
				
				if(choice.equals("q")) {
					
					System.out.println("Thanks for visiting!\nNumber of books: "+books);		
					
				}
				
				
					
				
					if(choice.equals("c"))	{
							if(books == 0){
								System.out.println("Can't change a book that was never there! Try adding one first.");
								break;
							}
					
					if(library.length > 0)
						System.out.println("What book do you want to change its info?");
						String changeBook = input.nextLine();
					
					for(int i = 0; i < library.length; i++)	
					{
						
						if (library[i] == null){
							continue;
							
						}
						
						String e = library[i].getTitle();
						if(e.equals(changeBook)){
							System.out.println("What do you want to change it to?");
							String newBook = input.nextLine();
							System.out.println("How many pages does it have now?");
							int newPages = input.nextInt();
							
						
						library[i].equals(newBook);
						library[i].equals(newPages);
						library[i].setTitle(newBook);
						library[i].setPages(newPages);
						
						System.out.println("Book added.\nTitle: "+library[i].getTitle()+"\nPages: "+library[i].getPages()+"\nNumber of books: "+books);	
						break;
						
						}
						
						if(!e.equals(changeBook))	
						{
							System.out.println("Wrong book. Try again.");
							break;

						
					
						}
						
				 
				
				}
						
					
			}

			
		}

	}	

	



	}
		
	
