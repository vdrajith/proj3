package dob;

public class Dao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		public void add(Book book) {
			Connection connection = ConnectionUtil.getConnection();

			String sql = "insert into books (name,price,author_name) values(?,?,?)";
			PreparedStatement preparedStatement = null;

			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, book.getName());
				preparedStatement.setFloat(2, book.getPrice());
				preparedStatement.setString(3, book.getAuthorName());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		

	}

}
