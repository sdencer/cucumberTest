######### add  ########
Given(/^Open the homepage$/) do
 visit "/"
 sleep 1
end

Given(/^Add a bookmark "([^"]*)"$/) do | book_name,book_addr |
  fill_in 'bookname', with: book_name
  fill_in 'bookaddr', with: book_addr
  find('submitBookMark').click;
  sleep 1
  end

Given(/^Hava (\d+) result$/) do |expect|
  sleep 1
  result = find('.rescount').text
  sleep 1
  expect(result).to eq expect.to_i
end
######### delete  ########
Given(/^Open the homepage$/) do
 visit "/"
 sleep 1
end

Given(/^Delete a bookmark "([^"]*)"$/) do | book_index |
  find('bookindex').click
  sleep 1
  end

Given(/^Hava (\d+) result$/) do |expect|
  sleep 1
  result = find('.rescount').text
  sleep 1
  expect(result).to eq expect.to_i
end
